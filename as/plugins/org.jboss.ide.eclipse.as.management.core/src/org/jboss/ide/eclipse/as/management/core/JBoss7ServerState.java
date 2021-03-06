/******************************************************************************* 
 * Copyright (c) 2011 Red Hat, Inc. 
 * Distributed under license by Red Hat, Inc. All rights reserved. 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * Red Hat, Inc. - initial API and implementation 
 ******************************************************************************/
package org.jboss.ide.eclipse.as.management.core;

import java.text.MessageFormat;

/**
 * @author André Dietisheim
 */
public enum JBoss7ServerState {
	STARTING, RUNNING, RESTART_REQUIRED;

	public static JBoss7ServerState valueOfIgnoreCase(String stateString) {
		JBoss7ServerState matchingState = null;
		if (stateString != null && stateString.length() > 0) {
			for (JBoss7ServerState availableState : values()) {
				if (stateString.equalsIgnoreCase(availableState.name())) {
					matchingState = availableState;
					break;
				}
			}
		}
		if (matchingState == null) {
			throw new IllegalArgumentException(MessageFormat.format(
					"No JBoss7ServerState enum for string {0}",
					stateString));
		}

		return matchingState;
	}
}
