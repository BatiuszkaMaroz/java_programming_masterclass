// package com.david.part3;

// import java.util.Random;

// class Message {
// private String message;
// private boolean empty = true;

// public synchronized String read() {
// System.err.println("R");
// while (empty) {
// //
// }

// empty = true;
// return message;
// }

// public synchronized void write(String message) {
// System.err.println("W");
// while (!empty) {
// //
// }

// empty = false;
// this.message = message;
// }
// }

// class Writer implements Runnable {
// Random random = new Random();
// private Message message;

// public Writer(Message message) {
// this.message = message;
// }

// public void run() {
// String messages[] = {
// "Humpty Dumpty sat on a wall",
// "Humpty Dumpty had a great fall",
// "All the king's horses and all the king's men",
// "Couldn't put Humpty together again",
// };

// for (int i = 0; i < messages.length; i++) {
// message.write(messages[i]);

// try {
// Thread.sleep(random.nextInt(2000));
// } catch (InterruptedException err) {
// //
// }
// }

// message.write("Finished");
// }
// }

// class Reader implements Runnable {
// Random random = new Random();
// private Message message;

// public Reader(Message message) {
// this.message = message;
// }

// public void run() {
// for (String latestMessage = message.read();
// !latestMessage.equals("Finished"); latestMessage = message.read()) {
// System.out.println(latestMessage);

// try {
// Thread.sleep(random.nextInt(2000));
// } catch (InterruptedException err) {
// //
// }
// }

// }
// }

// public class AppV1 {
// public static void main(String[] args) {
// Message message = new Message();

// (new Thread(new Writer(message))).start();
// (new Thread(new Reader(message))).start();
// }
// }

// /*
// * === OUTPUT 0 ===
// * W
// * R
// * Humpty Dumpty sat on a wall
// * R
// * === DESCRIPTION ===
// * Output differs because of random thread sleep time (and OS).
// * The problem is that when thread is executing a synchronized method for an
// * object, all other threads that invoke synchronized methods for the same
// * object are being blocked (suspend execution) until the first thread is done
// * with
// * the object.
// * So when `read` is called after `read`, program ends in infinite loop,
// * because
// * `read` loops until (empty == false), but there is no possibility to change
// * value of empty because read is blocking whole object
// */
