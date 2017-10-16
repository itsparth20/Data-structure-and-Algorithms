

import java.io.BufferedInputStream;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SocketFTP {

	public synchronized void connectToServer(String host, int port, String userName, String password)
			throws UnknownHostException, IOException {

		socket = new Socket(host, port);
		reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		String response = readFromServer();
		sendToServer("USER " + userName);
		response = readFromServer();
		sendToServer("PASS " + password);
		response = readFromServer();

	}

	public synchronized void stop() {
		try {
			sendToServer("QUIT");
		} finally {
			socket = null;
		}
	}

	public synchronized boolean putToServer(File file) throws FileNotFoundException, IOException {
		String filename = file.getName();
		return putToServer(new FileInputStream(file), filename);
	}

	public synchronized boolean putToServer(InputStream inputStream, String filename) throws IOException {

		BufferedInputStream input = new BufferedInputStream(inputStream);

		String response;
		Socket dataSocket = getDataSocket(filename);

		response = readFromServer();

		BufferedOutputStream output = new BufferedOutputStream(dataSocket.getOutputStream());
		byte[] buffer = new byte[4096];
		int bytesRead = 0;
		while ((bytesRead = input.read(buffer)) != -1) {
			output.write(buffer, 0, bytesRead);
		}
		closeOutputInput(input, output);

		response = readFromServer();
		return response.startsWith("226 ");
	}

	private Socket getDataSocket(String filename) throws IOException, UnknownHostException {
		sendToServer("PASV");
		String response = readFromServer();

		String ip = null;
		int port = -1;
		int ope = response.indexOf('(');
		int clos = response.indexOf(')', ope + 1);
		if (clos > 0) {
			String dataLink = response.substring(ope + 1, clos);
			StringTokenizer tokenizer = new StringTokenizer(dataLink, ",");

			ip = tokenizer.nextToken() + "." + tokenizer.nextToken() + "." + tokenizer.nextToken() + "."
					+ tokenizer.nextToken();
			port = Integer.parseInt(tokenizer.nextToken()) * 256 + Integer.parseInt(tokenizer.nextToken());

		}

		sendToServer("STOR " + filename);

		Socket dataSocket = new Socket(ip, port);
		return dataSocket;
	}

	private void closeOutputInput(BufferedInputStream input, BufferedOutputStream output) throws IOException {
		output.flush();
		output.close();
		input.close();
	}

	private void sendToServer(String line) {
		try {
			writer.write(line + "\r\n");
			writer.flush();
			if (deb) {
				System.out.println("> " + line);
			}
		} catch (IOException e) {
			socket = null;
		}
	}

	private String readFromServer() throws IOException {
		String line = reader.readLine();
		if (deb) {
			System.out.println("< " + line);
		}
		return line;
	}
	private BufferedReader reader = null;
	private BufferedWriter writer = null;
	private Socket socket = null;
	private static boolean deb = false;

	public static void main(String[] args) throws IOException {
		SocketFTP ftp = new SocketFTP();

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter ip: ");
		String ip = sc.nextLine();
		System.out.print("Enter UserName: ");
		String user = sc.nextLine();
		System.out.print("Enter Password: ");
		String password = sc.nextLine();
		ftp.connectToServer(ip, 21, user, password);
		System.out.println("Successfully connected to server");
		while (true) {
			String input = sc.nextLine();
			String[] arr = input.trim().split(" ");
			if (arr.length == 1 && arr[0].equalsIgnoreCase("quit")) {
				System.out.println("Bye");
				break;
			} else if (arr.length == 1 && arr[0].equalsIgnoreCase("ls")) {
				ftp.listDir(".");
			} else {
				if (arr[0].equalsIgnoreCase("put")) {
					File file = new File(arr[1]);
					boolean done = ftp.putToServer(file);
					System.out.println(done ? "File Transferd" : "Please try again");
				} else if (arr[0].equalsIgnoreCase("delete")) {
					ftp.delete(arr[1]);
				} else if (arr[0].equalsIgnoreCase("get")) {
					ftp.download(arr[1]);
					System.out.println("Downloading is DONE");
				}
			}
		}

	}

	private void delete(String fileName) {
		sendToServer("DELE " + fileName);
		System.out.println(fileName + " deleted");
	}

	public void listDir(String path) throws UnknownHostException, IOException {
		sendToServer("PASV");
		String response = readFromServer();

		String ip = null;
		int port = -1;
		int opening = response.indexOf('(');
		int closing = response.indexOf(')', opening + 1);
		if (closing > 0) {
			String dataLink = response.substring(opening + 1, closing);
			StringTokenizer tokenizer = new StringTokenizer(dataLink, ",");
			try {
				ip = tokenizer.nextToken() + "." + tokenizer.nextToken() + "." + tokenizer.nextToken() + "."
						+ tokenizer.nextToken();
				port = Integer.parseInt(tokenizer.nextToken()) * 256 + Integer.parseInt(tokenizer.nextToken());
			} catch (Exception e) {

			}
		}

		Socket dataTransferSocket = new Socket(ip, port);

		sendToServer("LIST " + path);

		BufferedReader reader = new BufferedReader(new InputStreamReader(dataTransferSocket.getInputStream()));
		String line = null;
		;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		reader.close();
		dataTransferSocket.close();

	}

	// Download
	public void download(String fileName) throws IOException {
		ServerSocket serverSocket = new ServerSocket(0);
		int i = serverSocket.getLocalPort();
		String socketAddress = getSocAdd(serverSocket.getLocalPort());

		sendToServer("TYPE I");

		sendToServer("PORT " + socketAddress);

		sendToServer("RETR " + fileName);

		Socket dataTransferSocket = serverSocket.accept();

		FileOutputStream out = new FileOutputStream(fileName);
		InputStream in = dataTransferSocket.getInputStream();
		byte[] buffer = new byte[4096];
		int bytesRead = -1;
		while ((bytesRead = in.read(buffer)) > -1) {
			out.write(buffer, 0, bytesRead);
		}
		out.flush();
		out.close();
		in.close();

		dataTransferSocket.close();

	}

	private String getSocAdd(int port) {
		String add = null;
		try {
			add = InetAddress.getLocalHost().getHostAddress();
			add = add.replace('.', ',');
		} catch (Exception e) {

		}
		return add + "," + (port >> 8) + "," + (port & 255);
	}
}