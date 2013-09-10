/*
 * Sonar JavaScript Plugin
 * Copyright (C) 2011 SonarSource and Eriks Nukis
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.javascript.checks;

import com.sonar.sslr.squid.checks.CheckMessagesVerifier;
import org.junit.Test;
import org.sonar.javascript.JavaScriptAstScanner;
import org.sonar.squid.api.SourceFile;

import java.io.File;

public class FutureReservedWordsCheckTest {

  @Test
  public void test() {
    FutureReservedWordsCheck check = new FutureReservedWordsCheck();

    SourceFile file = JavaScriptAstScanner.scanSingleFile(new File("src/test/resources/checks/futureReservedWords.js"), check);
    CheckMessagesVerifier.verify(file.getCheckMessages())
        .next().atLine(1).withMessage("Rename 'implements' identifier to prevent potential conflicts with future evolutions of the JavaScript language.")
        .next().atLine(2).withMessage("Rename 'interface' identifier to prevent potential conflicts with future evolutions of the JavaScript language.")
        .next().atLine(3).withMessage("Rename 'package' identifier to prevent potential conflicts with future evolutions of the JavaScript language.")
        .next().atLine(4).withMessage("Rename 'private' identifier to prevent potential conflicts with future evolutions of the JavaScript language.")
        .next().atLine(5).withMessage("Rename 'protected' identifier to prevent potential conflicts with future evolutions of the JavaScript language.")
        .next().atLine(6).withMessage("Rename 'public' identifier to prevent potential conflicts with future evolutions of the JavaScript language.")
        .next().atLine(7).withMessage("Rename 'static' identifier to prevent potential conflicts with future evolutions of the JavaScript language.")
        .next().atLine(8).withMessage("Rename 'yield' identifier to prevent potential conflicts with future evolutions of the JavaScript language.")
        .noMore();
  }

}
