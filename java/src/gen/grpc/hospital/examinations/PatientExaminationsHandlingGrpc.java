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
public final class PatientExaminationsHandlingGrpc {

  private PatientExaminationsHandlingGrpc() {}

  public static final String SERVICE_NAME = "PatientExaminationsHandling";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<gen.grpc.hospital.examinations.Patient,
      gen.grpc.hospital.examinations.Examination> METHOD_GET_EXAMINATION_FOR_PATIENT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "PatientExaminationsHandling", "GetExaminationForPatient"),
          io.grpc.protobuf.ProtoUtils.marshaller(gen.grpc.hospital.examinations.Patient.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(gen.grpc.hospital.examinations.Examination.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PatientExaminationsHandlingStub newStub(io.grpc.Channel channel) {
    return new PatientExaminationsHandlingStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PatientExaminationsHandlingBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PatientExaminationsHandlingBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static PatientExaminationsHandlingFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PatientExaminationsHandlingFutureStub(channel);
  }

  /**
   */
  public static abstract class PatientExaminationsHandlingImplBase implements io.grpc.BindableService {

    /**
     */
    public void getExaminationForPatient(gen.grpc.hospital.examinations.Patient request,
        io.grpc.stub.StreamObserver<gen.grpc.hospital.examinations.Examination> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_EXAMINATION_FOR_PATIENT, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_EXAMINATION_FOR_PATIENT,
            asyncUnaryCall(
              new MethodHandlers<
                gen.grpc.hospital.examinations.Patient,
                gen.grpc.hospital.examinations.Examination>(
                  this, METHODID_GET_EXAMINATION_FOR_PATIENT)))
          .build();
    }
  }

  /**
   */
  public static final class PatientExaminationsHandlingStub extends io.grpc.stub.AbstractStub<PatientExaminationsHandlingStub> {
    private PatientExaminationsHandlingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PatientExaminationsHandlingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PatientExaminationsHandlingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PatientExaminationsHandlingStub(channel, callOptions);
    }

    /**
     */
    public void getExaminationForPatient(gen.grpc.hospital.examinations.Patient request,
        io.grpc.stub.StreamObserver<gen.grpc.hospital.examinations.Examination> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_EXAMINATION_FOR_PATIENT, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PatientExaminationsHandlingBlockingStub extends io.grpc.stub.AbstractStub<PatientExaminationsHandlingBlockingStub> {
    private PatientExaminationsHandlingBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PatientExaminationsHandlingBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PatientExaminationsHandlingBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PatientExaminationsHandlingBlockingStub(channel, callOptions);
    }

    /**
     */
    public gen.grpc.hospital.examinations.Examination getExaminationForPatient(gen.grpc.hospital.examinations.Patient request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_EXAMINATION_FOR_PATIENT, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PatientExaminationsHandlingFutureStub extends io.grpc.stub.AbstractStub<PatientExaminationsHandlingFutureStub> {
    private PatientExaminationsHandlingFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PatientExaminationsHandlingFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PatientExaminationsHandlingFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PatientExaminationsHandlingFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<gen.grpc.hospital.examinations.Examination> getExaminationForPatient(
        gen.grpc.hospital.examinations.Patient request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_EXAMINATION_FOR_PATIENT, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_EXAMINATION_FOR_PATIENT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PatientExaminationsHandlingImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PatientExaminationsHandlingImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_EXAMINATION_FOR_PATIENT:
          serviceImpl.getExaminationForPatient((gen.grpc.hospital.examinations.Patient) request,
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

  private static final class PatientExaminationsHandlingDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return gen.grpc.hospital.examinations.HospitalExaminationsProtos.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PatientExaminationsHandlingGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PatientExaminationsHandlingDescriptorSupplier())
              .addMethod(METHOD_GET_EXAMINATION_FOR_PATIENT)
              .build();
        }
      }
    }
    return result;
  }
}
