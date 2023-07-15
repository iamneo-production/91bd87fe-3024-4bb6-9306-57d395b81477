import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import Validation from './signupvalid';
import axios from 'axios';

function Signup() {
  const [values, setValues] = useState({
    name: '',
    email: '',
    password: ''
  });
  const navigate = useNavigate();
  const [errors, setErrors] = useState({});

  const handleInput = (event) => {
    setValues((prev) => ({ ...prev, [event.target.name]: event.target.value }));
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    const err = Validation(values);
    setErrors(err);

    if (err.name === '' && err.email === '' && err.password === '') {
      axios
        .post('localhost:8081/register', values)
        .then((res) => {
          navigate('/login');
        })
        .catch((err) => console.log(err));
    }
  };

  return (
    <div className="d-flex justify-content-center align-items-center vh-100">
      <div className="bg-white p-3 rounded w-25">
        <h2>SignUp your Account</h2>
        <hr />
        <form action="" onSubmit={handleSubmit}>
          <div className="mb-3">
            <label htmlFor="name">
              <strong>Name</strong>
            </label>
            <input type="text" placeholder="Enter Name" name="name" onChange={handleInput} className="form-control rounded-0"/>
            {errors.name && <span className="text-danger">{errors.name}</span>}
          </div>
          <div className="mb-3">
            <label htmlFor="email"><strong>Email</strong></label>
            <input type="email" placeholder="Enter Email" name="email" onChange={handleInput} className="form-control rounded-0"/>
            {errors.email && <span className="text-danger">{errors.email}</span>}
          </div>
          <div className="mb-3">
            <label htmlFor="password"><strong>Password</strong></label>
            <input type="password" placeholder="Enter Password" name="password" onChange={handleInput} className="form-control rounded-0"/>
            {errors.password && (<span className="text-danger">{errors.password}</span>)}
          </div>
          <button type="submit" className="btn btn-success w-100 rounded-0">Sign up</button>
          <hr />
          <Link to="/login" className="btn btn-default border w-100 bg-light rounded-0 text-decoration-none">Login</Link>
        </form>
      </div>
      <div className='bg-white p-3 rounded w-25'>
            <img src="https://media.istockphoto.com/id/1161496973/vector/young-man-with-computer-fills-schedule-calendar-and-complete-business-task-for-work.jpg?s=612x612&w=0&k=20&c=AvapetRgP2Ekb2OTp1WMAwOmknVuOq_3hie3c4feYQI="/>
        </div>
    </div>
  );
}

export default Signup;
