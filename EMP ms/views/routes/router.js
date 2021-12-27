const express=require('express');

const router=express.Router();
const employeeController=require('./controller/employeeController');

router.get('/',(req,res)=>{
    res.render("addEmployee")
});



module.exports=router;