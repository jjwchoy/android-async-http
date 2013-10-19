package com.loopj.android.http;

import java.util.concurrent.Future;

/**
 * A Handle to an AsyncRequest which can be used to cancel a running request.
 * 
 */
public class RequestHandle {
	private final Future<?> request;
	
	public RequestHandle(Future<?> request) {
		this.request = request;
	}
	
	/**
	 * Attempts to cancel this request. This attempt will fail if the request has
	 * already completed, has already been cancelled, or could not be cancelled
	 * for some other reason. If successful, and this request has not started
	 * when cancel is called, this request should never run. If the request has
	 * already started, then the mayInterruptIfRunning parameter determines
	 * whether the thread executing this request should be interrupted in an
	 * attempt to stop the request.
	 * 
	 * After this method returns, subsequent calls to isDone() will always
	 * return true. Subsequent calls to isCancelled() will always return true
	 * if this method returned true.
	 */
	public boolean cancel(boolean mayInterruptIfRunning) {
		if (this.request == null) {
			return false;
		}
		return request.cancel(mayInterruptIfRunning);
	}
	
	public boolean isFinished() {
		if (this.request == null) {
			return true;
		}
		return request.isDone();
	}
	
	public boolean isCancelled() {
		if (this.request == null) {
			return false;
		}
		return request.isCancelled();
	}
}
