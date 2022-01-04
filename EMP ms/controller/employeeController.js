const express=require('express');
const router=express.Router();
const axios=require('axios');
function insertRecord(req, res) {
    
    axios({
        method: 'post',
        url: 'http://localhost:8084/employees/add',
        data: {
          firstName: req.body.firstName,
          lastName: req.body.lastName,
          email:req.body.email,
          mobile:req.body.mobile,
          city:req.body.city,
          gender:req.body.gender,
          departmentName:req.body.departmentName
        }
      }).then(function(employee){
        console.log(employee.data);
        res.redirect("/employee/list");
    })     
      
};


function update(req,res,eid) {
   

    axios({
        method: 'put',
        url: 'http://localhost:8084/employees/update',
        data: {
          id:eid,
          firstName: req.body.firstName,
          lastName: req.body.lastName,
          email:req.body.email,
          mobile:req.body.mobile,
          city:req.body.city,
          gender:req.body.gender,
          departmentName:req.body.departmentName,
         

        }
      }).then(function(employee){
        res.redirect("/employee/list");
      });
};






module.exports={insertRecord,update};