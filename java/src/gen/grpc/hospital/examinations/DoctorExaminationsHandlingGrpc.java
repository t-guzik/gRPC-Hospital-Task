package gen.grpc.hospital.examinations;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.2.0)",
    comments = "Source: hospital.proto")
public final class DoctorExaminationsHandlingGrpc {

  private DoctorExaminationsHandlingGrpc() {}

  public static final String SERVICE_NAME = "DoctorExaminationsHandling";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<gen.grpc.hospital.examinations.Patient,
      gen.grpc.hospital.examinations.Examination> METHOD_GET_EXAMINATION_FOR_DOCTOR =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "DoctorExaminationsHandling", "GetExaminationForDoctor"),
          io.grpc.protobuf.ProtoUtils.marshaller(gen.grpc.hospital.examinations.Patient.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(gen.grpc.hospital.examinations.Examination.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<gen.grpc.hospital.examinations.Parameter,
      gen.grpc.hospital.examinations.Examination> METHOD_GET_EXAMINATIONS_BY_PARAMETER =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING,
          generateFullMethodName(
              "DoctorExaminationsHandling", "GetExaminationsByParameter"),
          io.grpc.protobuf.ProtoUtils.marshaller(gen.grpc.hospital.examinations.Parameter.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(gen.grpc.hospital.examinations.Examination.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<gen.grpc.hospital.examinations.Patient,
      gen.grpc.hospital.examinations.Examination> METHOD_GET_EXAMINATIONS_BY_LASTNAME =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING,
          generateFullMethodName(
              "DoctorExaminationsHandling", "GetExaminationsByLastname"),
          io.grpc.protobuf.ProtoUtils.marshaller(gen.grpc.hospital.examinations.Patient.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(gen.grpc.hospital.examinations.Examination.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DoctorExaminationsHandlingStub newStub(io.grpc.Channel channel) {
    return new DoctorExaminationsHandlingStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DoctorExaminationsHandlingBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DoctorExaminationsHandlingBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static DoctorExaminationsHandlingFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DoctorExaminationsHandlingFutureStub(channel);
  }

  /**
   */
  public static abstract class DoctorExaminationsHandlingImplBase implements io.grpc.BindableService {

    /**
     */
    public void getExaminationForDoctor(gen.grpc.hospital.examinations.Patient request,
        io.grpc.stub.StreamObserver<gen.grpc.hospital.examinations.Examination> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_EXAMINATION_FOR_DOCTOR, responseObserver);
    }

    /**
     */
    public void getExaminationsByParameter(gen.grpc.hospital.examinations.Parameter request,
        io.grpc.stub.StreamObserver<gen.grpc.hospital.examinations.Examination> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_EXAMINATIONS_BY_PARAMETER, responseObserver);
    }

    /**
     */
    public void getExaminationsByLastname(gen.grpc.hospital.examinations.Patient request,
        io.grpc.stub.StreamObserver<gen.grpc.hospital.examinations.Examination> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_EXAMINATIONS_BY_LASTNAME, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_EXAMINATION_FOR_DOCTOR,
            asyncUnaryCall(
              new MethodHandlers<
                gen.grpc.hospital.examinations.Patient,
                gen.grpc.hospital.examinations.Examination>(
                  this, METHODID_GET_EXAMINATION_FOR_DOCTOR)))
          .addMethod(
            METHOD_GET_EXAMINATIONS_BY_PARAMETER,
            asyncServerStreamingCall(
              new MethodHandlers<
                gen.grpc.hospital.examinations.Parameter,
                gen.grpc.hospital.examinations.Examination>(
                  this, METHODID_GET_EXAMINATIONS_BY_PARAMETER)))
          .addMethod(
            METHOD_GET_EXAMINATIONS_BY_LASTNAME,
            asyncServerStreamingCall(
              new MethodHandlers<
                gen.grpc.hospital.examinations.Patient,
                gen.grpc.hospital.examinations.Examination>(
                  this, METHODID_GET_EXAMINATIONS_BY_LASTNAME)))
          .build();
    }
  }

  /**
   */
  public static final class DoctorExaminationsHandlingStub extends io.grpc.stub.AbstractStub<DoctorExaminationsHandlingStub> {
    private DoctorExaminationsHandlingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DoctorExaminationsHandlingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DoctorExaminationsHandlingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DoctorExaminationsHandlingStub(channel, callOptions);
    }

    /**
     */
    public void getExaminationForDoctor(gen.grpc.hospital.examinations.Patient request,
        io.grpc.stub.StreamObserver<gen.grpc.hospital.examinations.Examination> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_EXAMINATION_FOR_DOCTOR, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getExaminationsByParameter(gen.grpc.hospital.examinations.Parameter request,
        io.grpc.stub.StreamObserver<gen.grpc.hospital.examinations.Examination> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_GET_EXAMINATIONS_BY_PARAMETER, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getExaminationsByLastname(gen.grpc.hospital.examinations.Patient request,
        io.grpc.stub.StreamObserver<gen.grpc.hospital.examinations.Examination> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_GET_EXAMINATIONS_BY_LASTNAME, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DoctorExaminationsHandlingBlockingStub extends io.grpc.stub.AbstractStub<DoctorExaminationsHandlingBlockingStub> {
    private DoctorExaminationsHandlingBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DoctorExaminationsHandlingBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DoctorExaminationsHandlingBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DoctorExaminationsHandlingBlockingStub(channel, callOptions);
    }

    /**
     */
    public gen.grpc.hospital.examinations.Examination getExaminationForDoctor(gen.grpc.hospital.examinations.Patient request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_EXAMINATION_FOR_DOCTOR, getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<gen.grpc.hospital.examinations.Examination> getExaminationsByParameter(
        gen.grpc.hospital.examinations.Parameter request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_GET_EXAMINATIONS_BY_PARAMETER, getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<gen.grpc.hospital.examinations.Examination> getExaminationsByLastname(
        gen.grpc.hospital.examinations.Patient request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_GET_EXAMINATIONS_BY_LASTNAME, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DoctorExaminationsHandlingFutureStub extends io.grpc.stub.AbstractStub<DoctorExaminationsHandlingFutureStub> {
    private DoctorExaminationsHandlingFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DoctorExaminationsHandlingFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DoctorExaminationsHandlingFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DoctorExaminationsHandlingFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<gen.grpc.hospital.examinations.Examination> getExaminationForDoctor(
        gen.grpc.hospital.examinations.Patient request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_EXAMINATION_FOR_DOCTOR, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_EXAMINATION_FOR_DOCTOR = 0;
  private static final int METHODID_GET_EXAMINATIONS_BY_PARAMETER = 1;
  private static final int METHODID_GET_EXAMINATIONS_BY_LASTNAME = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DoctorExaminationsHandlingImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DoctorExaminationsHandlingImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_EXAMINATION_FOR_DOCTOR:
          serviceImpl.getExaminationForDoctor((gen.grpc.hospital.examinations.Patient) request,
              (io.grpc.stub.StreamObserver<gen.grpc.hospital.examinations.Examination>) responseObserver);
          break;
        case METHODID_GET_EXAMINATIONS_BY_PARAMETER:
          serviceImpl.getExaminationsByParameter((gen.grpc.hospital.examinations.Parameter) request,
              (io.grpc.stub.StreamObserver<gen.grpc.hospital.examinations.Examination>) responseObserver);
          break;
        case METHODID_GET_EXAMINATIONS_BY_LASTNAME:
          serviceImpl.getExaminationsByLastname((gen.grpc.hospital.examinations.Patient) request,
              (io.grpc.stub.StreamObserver<gen.grpc.hospital.examinations.Examination>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class DoctorExaminationsHandlingDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return gen.grpc.hospital.examinations.HospitalExaminationsProtos.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (DoctorExaminationsHandlingGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DoctorExaminationsHandlingDescriptorSupplier())
              .addMethod(METHOD_GET_EXAMINATION_FOR_DOCTOR)
              .addMethod(METHOD_GET_EXAMINATIONS_BY_PARAMETER)
              .addMethod(METHOD_GET_EXAMINATIONS_BY_LASTNAME)
              .build();
        }
      }
    }
    return result;
  }
}
