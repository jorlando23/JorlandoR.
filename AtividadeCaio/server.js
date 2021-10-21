import express from 'express'
import {cursos} from'./cursos.js'

const app = express()


app.get('/cursos/navirai',function(request,response){
    let cursosNaviraí = cursos.filter(function(cursos){
        return cursos.municipio == "Naviraí"

    })
    response.json(cursosNaviraí)
})


app.listen(3000,function(){
    console.log("Server is running port 3000") 
})
