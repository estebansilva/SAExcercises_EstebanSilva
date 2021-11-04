Feature: Spotify Sign Up

  Scenario: Validar planes de la sección premium

    Given estoy en el pantalla de principal
    When Ingreso a la sección Premium
    Then Visualizo los planes


  Scenario Outline: Mensajes de validación

    Given estoy en el pantalla de principal
    When ingreso a la pagina de registro
    And escribo el email <email>
    Then visualizo el mensaje de validación <validation_msg>


    Examples:
      | email           | validation_msg                                                                                         |
      | ""              | "Es necesario que introduzcas tu correo electrónico."                                                  |
      | "ffff"          | "Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com" |
      | "test@test.com" | "Este correo electrónico ya está conectado a una cuenta. Inicia sesión."                               |


    Scenario: Visualización de links en terminos y condiciones

      Given estoy en el pantalla de principal
      When ingreso a la pagina de terminos y condiciones
      Then visualizo los links