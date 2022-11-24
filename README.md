# cinema



# cinema
endpoint registro de usuario http://localhost:8080/auth/register (POST)
  {"username": "usuario",
  "password": "12345"}
   
end point login de usuario http://localhost:8080/auth/login (POST)
 { "username": "usuario",
  "password": "12345"}

end point lista de peliculas http://localhost:8080/movies/list (GET)

end point lista de funciones http://localhost:8080/function-movie/list

end point lista de peliculas funcion http://localhost:8080/function-movie/{1} (GET)

end point sillas disponibles por funcion http://localhost:8080/function-movie/available-chairs/{idFuncion} (GET)

end point realizar reserva http://localhost:8080/reservation/user/{idUser}/create-functionmovie/{idFunMov}/id-card/{idCard} (POST)
{
"numberChair": cualquier numero,
}

end point listar tarjetas  por usuario http://localhost:8080/card/user/{idUser}/show-cards/ (GET)

http://localhost:8080/card/user/{idUser}/register (POST) 
   {
   "cardName": "x card",
    "number": 30753654,
    "expirationDate": "2022-05-10",
    "cvvOrCsc": "195"
    }
   
end point detalles per user http://localhost:8080/user/(idUSer)/details (GET)


/// version spring toools 

Spring Tool Suite 4 

Version: 4.14.0.RELEASE
Build Id: 202203131612

// java

11+
