package br.com.sqs_sender;

import java.time.LocalDate;
import java.util.Scanner;

import br.com.sqs_sender.services.SQSService;

public class App 
{
  public static void main( String[] args )
  {
    Scanner input = new Scanner(System.in);
		System.out.println("Digite a menssagem que deseja enviar: ");
		String message = input.nextLine();
    SQSService.sendMessage(message + " "+"mensagem feita no dia: " + LocalDate.now());
		input.close();
  }
}
