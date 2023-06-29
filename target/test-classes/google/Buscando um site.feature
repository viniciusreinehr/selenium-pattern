Feature: Buscar um site especifico
    Scenario: Buscando um site
        Given que eu acessei o google
        When eu busquei por "delfinocotas.com.br"
        Then o titulo da página começou com "delfinocotas.com.br - Pesquisa Google"