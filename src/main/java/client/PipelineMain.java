package client;

import com.studentReader.generated.stubs.Empty;
import com.studentReader.generated.stubs.Student;
import com.studentReader.generated.stubs.StudentObjectResponse;
import com.studentReader.generated.stubs.StudentServiceGrpc;
import io.grpc.ManagedChannel;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.*;
import org.apache.beam.sdk.transforms.SimpleFunction;
import org.apache.beam.sdk.values.*;

import java.util.ArrayList;
import java.util.List;

public class PipelineMain {

    public static void main(String[] args) {

        ManagedChannel channel=StudentClient.getChannelInstance();
        StudentServiceGrpc.StudentServiceBlockingStub stub=StudentServiceGrpc.newBlockingStub(channel);
        System.out.println("Sending request to server");
        StudentObjectResponse response= stub.getStudentList(Empty.newBuilder().build());
      // response.getStudentsList().forEach(student -> {System.out.println(student.getName());});
        List<Student> studList= new ArrayList<>();
        studList= response.getStudentsList();
        applyTransform(studList);

    }

    public static  void applyTransform(List<Student> studList){
        //System.out.println(stList);
        final TupleTag<String> CSEstudents=new TupleTag<String>(){};
        final TupleTag<String> ETCstudents=new TupleTag<String>(){};
        final TupleTag<String> MECHstudents=new TupleTag<String>(){};
        System.out.println("Applying transforms");
        Pipeline pipeline = Pipeline.create(PipelineOptionsFactory.fromArgs().withValidation().create());
        PCollection<Student> studentCollection=pipeline.apply(Create.of(studList));

        PCollectionTuple allTuples=
                studentCollection
                .apply(MapElements.via(new SimpleFunction<Student,String>() {
                    public String apply(Student stud) {
                        return stud.getRoll()+","+stud.getFname()+","+stud.getBranch();
                    }
                }))
                .apply(ParDo.of(new DoFn<String, String>() {
                    @ProcessElement
                    public void processElement(ProcessContext c)  {
                        //System.out.println(c.element().toString());
                        String studentArr[]=c.element().toString().split(",");
                        if(studentArr[2].equalsIgnoreCase("CSE")){
                            c.output(c.element());
                        }
                        if(studentArr[2].equalsIgnoreCase("ETC")){
                            c.output(ETCstudents,c.element());
                        }
                        if (studentArr[2].equalsIgnoreCase("MECH")){
                            c.output(MECHstudents,c.element());
                        }
                    }
                }).withOutputTags(CSEstudents, TupleTagList.of(ETCstudents).and(MECHstudents)));

        allTuples.get(CSEstudents).apply(TextIO.write().to("./src/main/output/CSEstudents").withSuffix(".csv").withoutSharding());
        allTuples.get(ETCstudents).apply(TextIO.write().to("./src/main/output/ETCstudents").withSuffix(".csv").withoutSharding());
        allTuples.get(MECHstudents).apply(TextIO.write().to("./src/main/output/MECHstudents").withSuffix(".csv").withoutSharding());
        System.out.println("Process completed, please check the output folder");
        pipeline.run().waitUntilFinish();

    }
}
