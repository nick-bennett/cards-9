/*
 *  Copyright 2020 Deep Dive Coding/CNM Ingenuity, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package edu.cnm.deepdive.model;

import java.util.Random;

/**
 * Declares (and provides some partial default implementation of) shuffling-related methods. This
 * is primarily intended to declare a standard set of methods for card-game-related shuffling
 * operations.
 *
 * @author Nicholas Bennett &amp; Deep Dive Coding Java + Android Cohort 9.
 */
public interface Shuffleable {

  /**
   * Shuffles an array or ordered collection (i.e. {@link java.util.List}) using the specified
   * source of randomness.
   *
   * @param rng source of randomness.
   */
  void shuffle(Random rng);

  /**
   * Returns a fallback source of randomness, to be used when the {@link #shuffle()} method is
   * invoked. Note that the default implementation returns an instance of {@link Random}, which is
   * generally <strong>not</strong> suitable for commercial gaming purposes.
   *
   * @return fallback source of randomness.
   */
  default Random getRng() {
    return new Random();
  }

  /**
   * Shuffles an array or ordered collection (i.e. {@link java.util.List}) using the source of
   * randomness provided by {@link #getRng()}.
   */
  default void shuffle() {
    shuffle(getRng());
  }

}
