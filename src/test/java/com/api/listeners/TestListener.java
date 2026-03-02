package com.api.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
	private static final Logger logger = LogManager.getLogger(TestListener.class);

	@Override
	public void onStart(ITestContext context) {
		logger.info("=== Test suite started: {} ===", context.getName());
		logger.info("Suite start time: {}", new java.util.Date(context.getStartDate().getTime()));
	}

	@Override
	public void onFinish(ITestContext context) {
		logger.info("=== Test suite finished: {} ===", context.getName());
		logger.info("Total: {} | Passed: {} | Failed: {} | Skipped: {}",
				context.getAllTestMethods().length,
				context.getPassedTests().size(),
				context.getFailedTests().size(),
				context.getSkippedTests().size());
		logger.info("Suite end time: {}", new java.util.Date(context.getEndDate().getTime()));
	}

	@Override
	public void onTestStart(ITestResult result) {
		logger.info("[START] {} :: {}", result.getTestClass().getName(), result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		long durationMs = result.getEndMillis() - result.getStartMillis();
		logger.info("[PASS] {} :: {} ({} ms)", result.getTestClass().getName(), result.getName(), durationMs);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		long durationMs = result.getEndMillis() - result.getStartMillis();
		logger.error("[FAIL] {} :: {} ({} ms)", result.getTestClass().getName(), result.getName(), durationMs);
		logger.error("Throwable: ", result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.warn("[SKIP] {} :: {} - Reason: {}", result.getTestClass().getName(), result.getName(),
				result.getThrowable() != null ? result.getThrowable().getMessage() : "unknown");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		logger.warn("[FAIL_WITHIN_SUCCESS_PCT] {} :: {}", result.getTestClass().getName(), result.getName());
		logger.warn("Throwable: ", result.getThrowable());
	}
}