package com.example.marshalling;

import org.jbpm.document.marshalling.DocumentMarshallingStrategy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CustomDocumentMarshalling extends DocumentMarshallingStrategy {

//    TODO: set cloud document storage service

    @Override
    public byte[] marshal(Context context, ObjectOutputStream objectOutputStream, Object o) throws IOException {
        throw new RuntimeException("Custom Marshalling Works!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    @Override
    public Object unmarshal(Context context, ObjectInputStream objectInputStream, byte[] object, ClassLoader classLoader) throws IOException, ClassNotFoundException {
        throw new RuntimeException("Custom UnMarshalling Works!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}
