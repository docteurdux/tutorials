package org.baeldung.cheatsheet;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

public class JavaTimer {

	public void scheduleTask(TimerTask task, long delay) throws InterruptedException {
		Timer timer = new Timer("Timer");
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				Assert.assertEquals("Timer", Thread.currentThread().getName());
			}
		}, delay);
	}

	public void cancelTask(Timer timer) {
		timer.cancel();
	}

	public void scheduleRepeatedTask(TimerTask task, long delay, long period) throws InterruptedException {
		Timer timer = new Timer("Timer");
		timer.scheduleAtFixedRate(task, delay, period);
	}

	public void cancelRepeatedTaskWithinTask(long delay, long period) throws InterruptedException {
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				cancel();
			}
		};
		Timer timer = new Timer("Timer");
		timer.scheduleAtFixedRate(task, delay, period);
	}

	public void taskCancelledWhenThreadQuits() throws InterruptedException {
		new Thread(new Runnable() {
			@Override
			public void run() {
				new Timer("Timer").scheduleAtFixedRate(new TimerTask() {
					@Override
					public void run() {
						// this task will never run since thread will exit too early
					}
				}, 1000L, 1000L);
			}

		}).start();
	}

	public void repeatedTaskWithExecutorService(TimerTask task, long delay, long period, TimeUnit timeUnit)
			throws InterruptedException {
		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		executor.scheduleAtFixedRate(task, delay, period, timeUnit);
		executor.shutdown();
	}

	public void shutdownExecutor(ScheduledExecutorService executor) throws InterruptedException {
		executor.shutdown();
	}

}
