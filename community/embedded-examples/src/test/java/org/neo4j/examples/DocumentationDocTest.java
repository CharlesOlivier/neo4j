/**
 * Licensed to Neo Technology under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Neo Technology licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
// START SNIPPET: sampleDocumentation
// START SNIPPET: _sampleDocumentation
package org.neo4j.examples;

import org.junit.Test;
import org.neo4j.kernel.impl.annotations.Documented;
import org.neo4j.test.GraphDescription.Graph;

import static org.neo4j.visualization.asciidoc.AsciidocHelper.*;

public class DocumentationDocTest extends AbstractJavaDocTestbase
{
    /**
     * This is a sample documentation test, demonstrating different ways of
     * bringing code and other artifacts into Asciidoc form. The title of the 
     * generated document is determined from the method name, replacing "+_+" with
     * " ".
     * 
     * Below you see a number of different ways to generate text from source,
     * inserting it into the JavaDoc documentation (really being Asciidoc markup)
     * via the +@@+ snippet markers and programmatic adding with runtime data
     * in the Java code.
     * 
     * - The annotated graph as http://www.graphviz.org/[GraphViz]-generated visualization:
     * 
     * @@graph
     * 
     * - A sample Cypher query:
     * 
     * @@cypher
     * 
     * - A sample text output snippet:
     * 
     * @@output
     * 
     * - a generated source link to the original GIThub source for this test:
     * 
     * @@github
     * 
     * - The full source for this example as a source snippet, highlighted as Java code:
     * 
     * @@sampleDocumentation
     * 
     * This is the end of this chapter.
     */
    @Test
    // signaling this to be a documentation test
    @Documented
    // the graph data setup as simple statements
    @Graph( "I know you" )
    // title is determined from the method name
    public void hello_world_Sample_Chapter()
    {
        // initialize the graph with the annotation data
        data.get();
        gen.get().addTestSourceSnippets( this.getClass(), "sampleDocumentation" );
        gen.get()
                .addGithubTestSourceLink( "github", this.getClass(),
                        "community/embedded-examples" );

        gen.get().addSnippet( "output",
                createOutputSnippet( "Hello graphy world!" ) );

        gen.get().addSnippet(
                "graph",
                createGraphVizWithNodeId( "Hello World Graph", graphdb(),
                        gen.get().getTitle() ) );
        // A cypher snippet referring to the generated graph in the start clause
        gen.get().addSnippet(
                "cypher",
                createCypherSnippet( "start n = node(" + data.get().get( "I" ).getId()
                                     + ") return n" ) );
    }
}
// END SNIPPET: _sampleDocumentation
// END SNIPPET: sampleDocumentation
