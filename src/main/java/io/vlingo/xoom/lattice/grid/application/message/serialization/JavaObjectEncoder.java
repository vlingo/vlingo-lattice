package io.vlingo.xoom.lattice.grid.application.message.serialization;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import io.vlingo.xoom.lattice.grid.application.message.Encoder;
import io.vlingo.xoom.lattice.grid.application.message.Message;

public final class JavaObjectEncoder implements Encoder {

  @Override
  public byte[] encode(Message message) {
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    try (ObjectOutputStream out = new ObjectOutputStream(bos)) {
      out.writeObject(message);
      out.flush();
      return bos.toByteArray();
    } catch (IOException e) {
      throw new RuntimeException("encode failed", e);
    }
  }
}
