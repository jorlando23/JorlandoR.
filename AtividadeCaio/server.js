import express from 'express'
import {cursos} from'./cursos.js'

const app = express()


app.get('/cursos/navirai',function(request,response){
    let cursosNavira√≠ = cursos.filter(function(cursos){
        return cursos.municipio == "Navira√≠"

    })
    response.json(cursosNavira√≠)
})


app.listen(3000,function(){
    console.log("Server is running port 3000") 
})
