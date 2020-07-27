package server;

import com.studentReader.generated.stubs.Empty;
import com.studentReader.generated.stubs.Student;
import com.studentReader.generated.stubs.StudentObjectResponse;
import com.studentReader.generated.stubs.StudentServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;

import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {

    @Override
    public void getStudentList(Empty request,
                               StreamObserver<StudentObjectResponse> responseObserver) {
        System.out.println("Request received");
        List<Student> studentlist = new ArrayList<>();
        Student student1 = Student.newBuilder().setFname("Somanshu").setLname("Shekhar").setRoll(10).setBranch("CSE").setZipcode(1234).build();
        Student student2 = Student.newBuilder().setFname("Somanshu1").setLname("Shekhar1").setRoll(11).setBranch("ETC").setZipcode(12345).build();
        Student student3 = Student.newBuilder().setFname("Somanshu2").setLname("Shekhar2").setRoll(12).setBranch("CSE").setZipcode(1234).build();
        Student student4 = Student.newBuilder().setFname("Somanshu3").setLname("Shekhar3").setRoll(13).setBranch("ETC").setZipcode(12345).build();
        Student student5 = Student.newBuilder().setFname("Somanshu4").setLname("Shekhar4").setRoll(14).setBranch("CSE").setZipcode(1234).build();
        Student student6 = Student.newBuilder().setFname("Somanshu5").setLname("Shekhar5").setRoll(15).setBranch("MECH").setZipcode(12346).build();
        Student student7 = Student.newBuilder().setFname("Somanshu6").setLname("Shekhar6").setRoll(16).setBranch("CSE").setZipcode(1234).build();
        studentlist.add(student1);
        studentlist.add(student2);
        studentlist.add(student3);
        studentlist.add(student4);
        studentlist.add(student5);
        studentlist.add(student6);
        studentlist.add(student7);
        StudentObjectResponse students = StudentObjectResponse.newBuilder().addAllStudents(studentlist).build();
       // students.forEach(student -> {System.out.println(student);} );
        responseObserver.onNext(students);
        responseObserver.onCompleted();
        System.out.println("Response sent successfully");
    }

}
