import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Funcionario;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.println("How many employees will be registered?");
		int n=sc.nextInt();
		List <Funcionario> lista= new ArrayList<>(n);
		for(int i=0;i<n;i++) {
			System.out.printf("Emplyoee #%d:%n", i+1);
			System.out.print("Id:");
			int id= sc.nextInt();
			while (hasId(lista, id)) {
				System.out.println("This id has already been taken");
				id=sc.nextInt();
			}
			System.out.print("Name:");
			String name= sc.nextLine();
			sc.nextLine();
			System.out.print("Salary:");
			double salario= sc.nextDouble();
			Funcionario func= new Funcionario(id, name, salario);
			lista.add(func);		
		}
		System.out.print("Enter the employee id that will have salary increase : %n");
		int id = sc.nextInt();
		Funcionario func= lista.stream().filter(x->x.getId()==id).findFirst().orElse(null);
		if (func == null) {
			System.out.println("This id does not exist!");
		}
		else {
			System.out.print("Enter the percentage: ");
			double percentagem = sc.nextDouble();
			func.acrescimosalario(percentagem);
		}
		System.out.println();
		System.out.println("List of employees:");
		for (Funcionario obj : lista) {
			System.out.println(obj);
		}
				
		sc.close(); 
	}
	
	
	public static boolean hasId(List <Funcionario> lista, int id) {
		Funcionario func= lista.stream().filter(x->x.getId()==id).findFirst().orElse(null); 
		return func!=null;
				}
		
	}

	


