import logo from './logo.svg';
import './App.css';
import {useEffect, useState} from "react";

function App() {

  const [greeting, setGreeting] = useState("Please Wait");

  useEffect(() => {
    fetch("/api/greeting")
    .then(res => {
      if(res.ok) {
        res.json().then(data=>{
          setGreeting(data);
        });
      } else {
        setGreeting("error from backend")
      }
    });

  }, []);

  return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo"/>
          <p>{greeting}</p>
          <a
              className="App-link"
              href="https://reactjs.org"
              target="_blank"
              rel="noopener noreferrer"
          >
            Learn React
          </a>
        </header>
      </div>
  );
}

export default App;
