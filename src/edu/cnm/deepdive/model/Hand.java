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

/**
 * Represents a collection of {@link Card} instances, presumably dealt to a single player in a card
 * game. This class is defined primarily to add the constraint that hands in card games are
 * virtually always comparable&mdash;that is, one hand can be compared to another, for
 * ordering/competition purposes. Concrete subclasses of this class must have include (or inherit)
 * implementations of {@link Comparable Comparable&lt;Card&gt;}.
 *
 * @author Nicholas Bennett &amp; Deep Dive Coding Java + Android Cohort 9.
 */
public abstract class Hand extends Pile implements Comparable<Card> {

}
