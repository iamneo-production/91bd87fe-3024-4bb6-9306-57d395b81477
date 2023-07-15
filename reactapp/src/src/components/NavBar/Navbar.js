import React, { useState } from 'react';
import { Navbar, Nav, NavDropdown } from 'react-bootstrap';
import { useSelector } from 'react-redux';
import BellIcon from '../icons/bell';
import { selectUser } from '../features/userslice';
import EnvelopeIcon from '../icons/envelope';
import { FaUser } from 'react-icons/fa';
import { AiFillSetting ,AiOutlineLogout} from 'react-icons/ai';
import './nav.css';
import { Container } from 'react-bootstrap';
import { connect } from 'react-redux';


const AppNavbar = (props) => {
  const reduxUser = props.username;
  const mail = reduxUser;
  const username = mail.substr(0, mail.indexOf('@'));
  const [isDropdownOpen, setIsDropdownOpen] = useState(false);

  const handleMouseEnter = () => {
    setIsDropdownOpen(true);
  };

  const handleMouseLeave = () => {
    setIsDropdownOpen(false);
  };

  return (
    <Container fluid>
    <Navbar expand="lg" variant="light" className="navbar navbar-expand-lg navbar-light" bg="transparent">
      <Navbar.Toggle aria-controls="basic-navbar-nav" className="fixed" />
      <Navbar.Collapse id="basic-navbar-nav">
        <Nav className="ml-auto align-items-center">
          <Nav.Link href="#home">
            <EnvelopeIcon />
          </Nav.Link>
          
          <Nav.Link >
            <BellIcon />
          </Nav.Link>
          <div className="profile-image ml-3" style={{marginRight:10}}>
            <img
              src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTsQ-YHX2i3RvTDDmpfnde4qyb2P8up7Wi3Ww&usqp=CAU"
              alt="Profile"
              className="rounded-circle"
              width="32"
              height="32"
            />
          </div><div style={{marginRight:30}}>{username}</div>
          
        </Nav>  
      </Navbar.Collapse>
    </Navbar>
    </Container>
  );
};
const mapstateToprops=(state)=>{
  return{
    username:state.user
  }
}

export default connect(mapstateToprops)(AppNavbar);

