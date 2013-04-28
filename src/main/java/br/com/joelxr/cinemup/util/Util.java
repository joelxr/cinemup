package br.com.joelxr.cinemup.util;

import java.util.List;

public class Util {

   private static final int LIST_SIZE = 120;

   public static String listAsString(List<?> lista) {
      StringBuilder retorno = new StringBuilder();

      if (lista.size() >= LIST_SIZE) {
         for (int i = 0; i < LIST_SIZE; i++) {
            if (lista.get(i).toString().contains("'")) continue;
            if (i != LIST_SIZE - 1) {
               retorno.append("'").append(lista.get(i).toString()).append("',");
            } else {
               retorno.append("'").append(lista.get(i).toString()).append("'");
            }
         }
         return retorno.toString();
      } else {
         for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).toString().contains("'")) continue;
            if (i != lista.size() - 1) {
               retorno.append("'").append(lista.get(i).toString()).append("',");
            } else {
               retorno.append("'").append(lista.get(i).toString()).append("'");
            }
         }
         return retorno.toString();
      }


   }
}
