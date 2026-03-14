package org.example.Collector;

import java.net.UnknownHostException;

public interface Collector<T> {
     T collect() throws UnknownHostException;
}
