/*
 * Copyright 2015 Fizzed Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fizzed.rocker.runtime;

import java.io.IOException;

public class WithBlock {
    
    static public interface Consumer0 {
        void accept() throws IOException;
    }
    
    static public interface Consumer1<V> {
        void accept(V v) throws IOException;
    }
    
    static public <V> void with(V v, boolean nullSafe, Consumer1<V> consumer) throws IOException {
        if (!nullSafe || v != null) {
            consumer.accept(v);
        }
    }
    
    static public <V> void with(V v, boolean nullSafe, Consumer1<V> consumer, Consumer0 elseConsumer) throws IOException {
        if (!nullSafe || v != null) {
            consumer.accept(v);
        } else {
            elseConsumer.accept();
        }
    }
    
}
