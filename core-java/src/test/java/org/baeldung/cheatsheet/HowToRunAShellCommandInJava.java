package org.baeldung.cheatsheet;

import java.io.File;
import java.util.List;
import java.util.concurrent.Executors;

import org.baeldung.utils.StreamGobbler;

public class HowToRunAShellCommandInJava {

	public int launchCommandAndReturnStatusCode(String command, String directory) throws Exception {
		Process process = Runtime.getRuntime().exec(String.format(command, directory));
		Executors.newSingleThreadExecutor().submit(new StreamGobbler(process.getInputStream()));
		return process.waitFor();
	}

	public int launchCommandWithProcessBuilderAndReturnStatusCode(List<String> arguments, String directory)
			throws Exception {
		ProcessBuilder builder = new ProcessBuilder();
		builder.command(arguments);
		builder.directory(new File(directory));
		Process process = builder.start();
		gobble(process);
		return process.waitFor();
	}

	public static void gobble(Process process) {
		Executors.newSingleThreadExecutor().submit(new StreamGobbler(process.getInputStream()));
	}
}
