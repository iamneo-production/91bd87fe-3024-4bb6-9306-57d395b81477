import {React,useEffect} from 'react';
import Login from './components/Login/login';
import Register from './components/Sigin/Signin';
import Landing from '../src/components/Pages/landinpage';
import GeneralLedger from './components/Pages/GeneralLedger';
import Expenses from './components/Pages/Expenses';
import Users from './components/Pages/Users';
import Inventory from './components/Pages/Inventory';
import Bill from './components/Pages/Bill';
import Payroll from './components/Pages/Payroll';
import Tax from './components/Pages/Tax';
import Analysis from './components/Pages/Analysis';
import Settings from './components/Pages/Settings';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

const App = () => {
  
  return (
    <div>
      <Router>
      <Routes>
        <Route path="/" element={<Landing />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path='/GeneralLedger' element={<GeneralLedger />}/>
        <Route path='/Users' element={<Users />}/>
        <Route path='/Expenses' element={<Expenses />}/>
        <Route path='/Analysis' element={<Analysis />}/>
        <Route path='/Bill' element={<Bill />}/>
        <Route path='/Inventory' element={<Inventory />}/>
        <Route path='/Payroll' element={<Payroll />}/>
        <Route path='/Tax' element={<Tax />}/>
        <Route path='/Settings' element={<Settings />}/>

        </Routes>
      </Router>
    </div>
  )
}

export default App