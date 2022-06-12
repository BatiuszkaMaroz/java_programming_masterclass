// package com.david.part4;

// import static com.david.part4.Color.*;
// import static com.david.part4.App.EOF;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Random;

// class Consumer implements Runnable {
// private List<String> buffer;
// private String color;

// public Consumer(List<String> buffer, String color) {
// this.buffer = buffer;
// this.color = color;
// }

// public void run() {
// while (true) {
// synchronized (buffer) {
// if (buffer.isEmpty())
// continue;

// if (buffer.get(0).equals(EOF)) {
// log("Exiting...");
// break;
// } else {
// log("Removed " + buffer.remove(0));
// }
// }
// }
// }

// private void log(String text) {
// System.out.println(color + text + ANSI_RESET);
// }
// }

// class Producer implements Runnable {
// private Random random = new Random();
// private List<String> buffer;
// private String color;

// public Producer(List<String> buffer, String color) {
// this.buffer = buffer;
// this.color = color;
// }

// public void run() {
// String[] nums = { "1", "2", "3", "4", "5" };

// for (String num : nums) {
// try {
// log("Adding " + num);
// synchronized (buffer) {
// buffer.add(num);
// }

// Thread.sleep(random.nextInt(1000));
// } catch (InterruptedException err) {
// log("Producer was interrupted");
// }
// }

// log("Adding EOF and exiting...");
// synchronized (buffer) {
// buffer.add(EOF);
// }
// }

// private void log(String text) {
// System.out.println(color + text + ANSI_RESET);
// }
// }

// public class App {
// public static final String EOF = "EOF";

// public static void main(String[] args) {
// List<String> buffer = new ArrayList<String>();
// Producer producer = new Producer(buffer, ANSI_RED);
// Consumer consumer1 = new Consumer(buffer, ANSI_GREEN);
// Consumer consumer2 = new Consumer(buffer, ANSI_CYAN);

// new Thread(producer).start();
// new Thread(consumer1).start();
// new Thread(consumer2).start();
// }
// }

// /*
// * === DESCRIPTION ===
// * Critical section (buffer) is synchronized.
// */
