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
public final class LabWorkerExaminationsHandlingGrpc {

  private LabWorkerExaminationsHandlingGrpc() {}

  public static final String SERVICE_NAME = "LabWorkerExaminationsHandling";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<gen.grpc.hospital.examinations.Examination,
      gen.grpc.hospital.examinations.Status> METHOD_PUT_EXAMINATION =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "LabWorkerExaminationsHandling", "PutExamination"),
          io.grpc.protobuf.ProtoUtils.marshaller(gen.grpc.hospital.examinations.Examination.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(gen.grpc.hospital.examinations.Status.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LabWorkerExaminationsHandlingStub newStub(io.grpc.Channel channel) {
    return new LabWorkerExaminationsHandlingStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LabWorkerExaminationsHandlingBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LabWorkerExaminationsHandlingBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static LabWorkerExaminationsHandlingFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LabWorkerExaminationsHandlingFutureStub(channel);
  }

  /**
   */
  public static abstract class LabWorkerExaminationsHandlingImplBase implements io.grpc.BindableService {

    /**
     */
    public void putExamination(gen.grpc.hospital.examinations.Examination request,
        io.grpc.stub.StreamObserver<gen.grpc.hospital.examinations.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_PUT_EXAMINATION, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_PUT_EXAMINATION,
            asyncUnaryCall(
              new MethodHandlers<
                gen.grpc.hospital.examinations.Examination,
                gen.grpc.hospital.examinations.Status>(
                  this, METHODID_PUT_EXAMINATION)))
          .build();
    }
  }

  /**
   */
  public static final class LabWorkerExaminationsHandlingStub extends io.grpc.stub.AbstractStub<LabWorkerExaminationsHandlingStub> {
    private LabWorkerExaminationsHandlingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LabWorkerExaminationsHandlingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LabWorkerExaminationsHandlingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LabWorkerExaminationsHandlingStub(channel, callOptions);
    }

    /**
     */
    public void putExamination(gen.grpc.hospital.examinations.Examination request,
        io.grpc.stub.StreamObserver<gen.grpc.hospital.examinations.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_PUT_EXAMINATION, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class LabWorkerExaminationsHandlingBlockingStub extends io.grpc.stub.AbstractStub<LabWorkerExaminationsHandlingBlockingStub> {
    private LabWorkerExaminationsHandlingBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LabWorkerExaminationsHandlingBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LabWorkerExaminationsHandlingBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LabWorkerExaminationsHandlingBlockingStub(channel, callOptions);
    }

    /**
     */
    public gen.grpc.hospital.examinations.Status putExamination(gen.grpc.hospital.examinations.Examination request) {
      return blockingUnaryCall(
          getChannel(), METHOD_PUT_EXAMINATION, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class LabWorkerExaminationsHandlingFutureStub extends io.grpc.stub.AbstractStub<LabWorkerExaminationsHandlingFutureStub> {
    private LabWorkerExaminationsHandlingFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LabWorkerExaminationsHandlingFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LabWorkerExaminationsHandlingFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LabWorkerExaminationsHandlingFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<gen.grpc.hospital.examinations.Status> putExamination(
        gen.grpc.hospital.examinations.Examination request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_PUT_EXAMINATION, getCallOptions()), request);
    }
  }

  private static final int METHODID_PUT_EXAMINATION = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LabWorkerExaminationsHandlingImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LabWorkerExaminationsHandlingImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PUT_EXAMINATION:
          serviceImpl.putExamination((gen.grpc.hospital.examinations.Examination) request,
              (io.grpc.stub.StreamObserver<gen.grpc.hospital.examinations.Status>) responseObserver);
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

  private static final class LabWorkerExaminationsHandlingDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return gen.grpc.hospital.examinations.HospitalExaminationsProtos.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (LabWorkerExaminationsHandlingGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LabWorkerExaminationsHandlingDescriptorSupplier())
              .addMethod(METHOD_PUT_EXAMINATION)
              .build();
        }
      }
    }
    return result;
  }
}
