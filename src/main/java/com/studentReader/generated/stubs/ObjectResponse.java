// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: objectResponse.proto

package com.studentReader.generated.stubs;

public final class ObjectResponse {
  private ObjectResponse() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_prime_Empty_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_prime_Empty_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_prime_StudentObjectResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_prime_StudentObjectResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_prime_Student_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_prime_Student_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024objectResponse.proto\022\005prime\"\007\n\005Empty\"9" +
      "\n\025StudentObjectResponse\022 \n\010students\030\001 \003(" +
      "\0132\016.prime.Student\"V\n\007Student\022\r\n\005Fname\030\001 " +
      "\001(\t\022\r\n\005lname\030\002 \001(\t\022\014\n\004roll\030\003 \001(\005\022\016\n\006bran" +
      "ch\030\004 \001(\t\022\017\n\007zipcode\030\005 \001(\0052P\n\016StudentServ" +
      "ice\022>\n\016getStudentList\022\014.prime.Empty\032\034.pr" +
      "ime.StudentObjectResponse\"\000B%\n!com.stude" +
      "ntReader.generated.stubsP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_prime_Empty_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_prime_Empty_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_prime_Empty_descriptor,
        new java.lang.String[] { });
    internal_static_prime_StudentObjectResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_prime_StudentObjectResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_prime_StudentObjectResponse_descriptor,
        new java.lang.String[] { "Students", });
    internal_static_prime_Student_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_prime_Student_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_prime_Student_descriptor,
        new java.lang.String[] { "Fname", "Lname", "Roll", "Branch", "Zipcode", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
