const express=require('express');
const router=express.Router();
const axios=require('axios');
const bodyparser=require('body-parser');
const app=express();
app.use(bodyparser.json());
//home page
const controller=require('../controller/employeeController');
router.get('/',(req,res)=>{
    res.render("addEmployee")
});


//adding data 
router.post('/add', (req, res) => {
    
 controller.insertRecord(req,res);
});


//updating data
router.post('/update/:id', (req,res) => {
  
    controller.update(req,res,req.params.id);
});


//get all employee
router.get('/list',(req,res)=>{
axios.get('http://localhost:8084/employees/getAll').then(function(employees){
        console.log(employees.data)
        res.render('../views/list',{'employees' : employees.data});
    })

});

//edit employee by id
router.get('/edit/:id', (req,res)=>{
    let eid=req.params.id;
    axios.get('http://localhost:8084/employees/get/byId',{
        params: {
          id: eid
        }
      }).then(function(employee){
        res.render("../views/editEmployee", { employee: employee.data});
    })        
});


//view employee by id
router.get('/view/:id', (req,res)=>{
    let eid=req.params.id;
    axios.get('http://localhost:8084/employees/get/byId',{
        params: {
          id: eid
        }
      }).then(function(employee){
        res.render("../views/view", { employee: employee.data});
    })     
});

//delete employee by id
router.get('/delete/:id',(req, res)=> {
    let eid=req.params.id;
    axios.delete('http://localhost:8084/employees/delete/byId',{
        params: {
          id: eid
        }
      }).then(function(){
        res.redirect("/employee/list")
       
    }) 
});





       
       
 


router.get('/edit/:id', (req,res)=>{
    
    controller.getEmployeeById();
        res.render("../views/editEmployee", { employee: employee });
      });

      


module.exports=router;