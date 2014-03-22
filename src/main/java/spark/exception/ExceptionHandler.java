/*
 * Copyright 2011- Per Wendel
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package spark.exception;

import spark.*;

public abstract class ExceptionHandler extends Filter {
	/**
	 * Holds the type of exception that this filter will handle
	 */
	protected Class<? extends Exception> exceptionClass;

	/**
	 * Initializes the filter with the provided exception type
	 *
	 * @param exceptionClass Type of exception
	 */
	public ExceptionHandler(Class<? extends Exception> exceptionClass) {
		this.exceptionClass = exceptionClass;
	}

	/**
	 * Returns type of exception that this filter will handle
	 *
	 * @return Type of exception
	 */
	public Class<? extends Exception> getExceptionClass() {
		return exceptionClass;
	}

	/**
	 * Returns type of exception that this filter will handle
	 *
	 * @param exceptionClass Type of exception
	 */
	public void setExceptionClass(Class<? extends Exception> exceptionClass) {
		this.exceptionClass = exceptionClass;
	}

	/**
	 * This method is hidden for the ExceptionHandler filter
	 *
	 * @param request The request object providing information about the HTTP request
	 * @param response The response object providing functionality for modifying the response
	 */
	@Override
	public final void handle(Request request, Response response) { }

	/**
	 * Invoked when an exception that is mapped to this handler occurs during routing
	 *
	 * @param exception The exception that was thrown during routing
	 * @param request The request object providing information about the HTTP request
	 * @param response The response object providing functionality for modifying the response
	 */
	public abstract void handle(Exception exception, Request request, Response response);
}
