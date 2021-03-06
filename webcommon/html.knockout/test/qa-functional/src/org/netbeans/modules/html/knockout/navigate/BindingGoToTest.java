/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.html.knockout.navigate;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Test;
import org.netbeans.junit.NbModuleSuite;
import org.netbeans.modules.html.knockout.GeneralKnockout;

/**
 *
 * @author vriha
 */
public class BindingGoToTest extends GeneralKnockout {

    public BindingGoToTest(String args) {
        super(args);
    }

    public static Test suite() {
        return NbModuleSuite.create(NbModuleSuite.createConfiguration(BindingGoToTest.class).addTest(
                "createApplication",
                "testClick",
                "testForeach"
        ).enableModules(".*").clusters(".*").honorAutoloadEager(true));
    }

    public void createApplication() {
        try {
            startTest();
            openDataProjects("sample");
            openFile("index.html", "sample");
            waitScanFinished();
            endTest();
        } catch (IOException ex) {
            Logger.getLogger(BindingGoToTest.class.getName()).log(Level.INFO, "Opening project", ex);
        }
    }

    public void testClick() {
        startTest();
        navigate("index.html", "model1.js", 9, 33, 1, 1);
        endTest();
    }

    public void testForeach() {
        startTest();
        navigate("index.html", "model1.js", 2, 28, 1, 1);
        endTest();
    }

    public void testComputed() {
        startTest();
        navigate("index.html", "model1.js", 11, 31, 1, 1);
        endTest();
    }

}
