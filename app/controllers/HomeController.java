package controllers;

import play.mvc.*;
import java.util.Map;

public class HomeController extends Controller {

    public Result index() {
        return ok(views.html.index.render());
    }

    public Result media() {
      return ok(views.html.formMedia.render());
    }
    public Result formMedia() {
      String nome = request().getQueryString("nome");
      int a = Integer.parseInt(
        request().getQueryString("a"));
      int b = Integer.parseInt(
        request().getQueryString("b"));
      int media = (a+b)/2;
      String situacao = request().getQueryString("situacao");
      if (media >= 60) situacao = "Aprovado";
      else if (media < 30) situacao = "Reprovado";
      else if (media < 60 && media >= 30) situacao = "Prova Final";
      return ok(views.html.respostaMedia.render(a, b, media, nome, situacao));
    }

    public Result mediaPost() {
      return ok(views.html.formMediaPost.render());
    }

    public Result formMediaPost() {
      Map<String, String[]> r =
          request().body().asFormUrlEncoded();
      String nome = r.get("nome")[0];
      int a  = Integer.parseInt(r.get("a")[0]);
      int b  = Integer.parseInt(r.get("b")[0]);
      int m = (a+b)/2;
      String situacao = r.get("situacao")[0];

      return ok(views.html.respostaMedia.render(a, b, m, nome, situacao));
    }

}