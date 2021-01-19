const PROXY_CONFIG = [
  {
    context: [
      "/projects",
      "/projects/all",
      "/projectsByName",
    ],
    target: "http://localhost:8081",
    secure: false
  },
  {
    context: [
      "/compile",
    ],
    target: "http://localhost:8082",
    secure: false
  }
]

module.exports = PROXY_CONFIG;
