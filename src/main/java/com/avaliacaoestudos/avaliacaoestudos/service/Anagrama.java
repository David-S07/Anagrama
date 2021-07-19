package com.avaliacaoestudos.avaliacaoestudos.service;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Anagrama {
    private String palavra = "";
    private String anagramas = "";
    private int quantidade = 0;
    List<Anagrama> resultado = new ArrayList<>();

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public String getAnagramas() {
        return anagramas;
    }

    public void setAnagramas(String anagramas) {
        this.anagramas = anagramas;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public static boolean isAnagrama(String palavra, String palavraComp) {

        char[] a = palavra.toCharArray();
        char[] b = palavraComp.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        if (Arrays.equals(a, b)) {
            return true;
        } else {
            return false;
        }
    }

    public void test() throws IOException {
        File file = new File("teste.txt");

        String textoCompleto = "";

        try (
            BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line = br.readLine();

            while (line != null) {

                textoCompleto += " " + line;
                line = br.readLine();

            }
            String[] palavrasArray = textoCompleto.trim().toLowerCase().replaceAll("\\p{Punct}", "").split(" ");
            Object[] palavras = Arrays.stream(palavrasArray).collect(Collectors.toSet()).toArray();


            for (int i = 0; i < palavras.length; i++) {

                String palavra = palavras[i].toString();
                boolean b = false;
                for (Anagrama anagrama : resultado) {
                    if (isAnagrama(palavra, anagrama.getPalavra())) {
                        b = true;
                        break;
                    }
                }
                if (b)
                    continue;

                Anagrama anagrama = new Anagrama();
                String anagramas = "";
                anagrama.setPalavra(palavra);

                for (int j = 0; j < palavras.length; j++) {
                    String palavraComp = palavras[j].toString();
                    if (i == j || palavra.equals(palavraComp)) {
                        continue;
                    } else {
                        boolean isAnagrama = isAnagrama(palavra, palavraComp);
                        if (isAnagrama) {
                            if (anagrama.getAnagramas().indexOf(palavraComp) == -1) {
                                anagrama.setAnagramas(anagrama.getAnagramas() + " " + palavraComp);
                            }
                        }
                    }
                }
                if (!anagrama.getAnagramas().equals("")) {
                    resultado.add(anagrama);
                }
            }
            System.out.println(resultado.size());
            for (Anagrama anagrama : resultado) {
                System.out.println(anagrama.getPalavra() + " " + anagrama.getAnagramas());

            }


        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Anagrama save = new Anagrama();

            String palll = String.valueOf(resultado).replaceAll("\\p{Punct}", "");
            int quantidade = resultado.size();

            save.salvar(palll, quantidade);
        }

    }

    public String salvar(String palll, int quantidade) throws IOException {
        FileWriter fw = null;
        PrintWriter pw = null;
        try {

            fw = new FileWriter("resultadoTeste.txt");
            pw = new PrintWriter(fw);

            pw.println(palll + quantidade);
            pw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
            if(fw != null) {
                fw.close();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return palavra + anagramas + "\n";
    }
}