// package com.david.part4;

// import static com.david.part4.Color.*;
// import static com.david.part4.App.EOF;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Random;
// import java.util.concurrent.locks.ReentrantLock;

// class Consumer implements Runnable {
// private List<String> buffer;
// private String color;
// private ReentrantLock bufferLock;

// public Consumer(List<String> buffer, String color, ReentrantLock bufferLock)
// {
// this.buffer = buffer;
// this.color = color;
// this.bufferLock = bufferLock;
// }

// public void run() {
// int counter = 0;

// while (true) {
// if (bufferLock.tryLock()) {
// try {
// if (buffer.isEmpty())
// continue;

// log("The counter = " + counter);
// counter = 0;

// if (buffer.get(0).equals(EOF)) {
// log("Exiting...");
// break;
// } else {
// log("Removed " + buffer.remove(0));
// }
// } finally {
// bufferLock.unlock();
// }
// } else {
// try {
// Thread.sleep(1000);
// } catch (InterruptedException err) {
// //
// }

// counter++;
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
// private ReentrantLock bufferLock;

// public Producer(List<String> buffer, String color, ReentrantLock bufferLock)
// {
// this.buffer = buffer;
// this.color = color;
// this.bufferLock = bufferLock;
// }

// public void run() {
// String[] nums = { "1", "2", "3", "4", "5" };

// for (String num : nums) {
// try {
// log("Adding " + num);

// bufferLock.lock();
// try {
// buffer.add(num);
// } finally {
// bufferLock.unlock();
// }

// Thread.sleep(random.nextInt(1000));
// } catch (InterruptedException err) {
// log("Producer was interrupted");
// }
// }

// log("Adding EOF and exiting...");

// bufferLock.lock();
// try {
// buffer.add(EOF);
// } finally {
// bufferLock.unlock();
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
// ReentrantLock bufferLock = new ReentrantLock();

// Producer producer = new Producer(buffer, ANSI_RED, bufferLock);
// Consumer consumer1 = new Consumer(buffer, ANSI_GREEN, bufferLock);
// Consumer consumer2 = new Consumer(buffer, ANSI_CYAN, bufferLock);

// new Thread(producer).start();
// new Thread(consumer1).start();
// new Thread(consumer2).start();
// }
// }

// /*
// * === DESCRIPTION ===
// * Critical section (buffer) is synchronized.
// */
