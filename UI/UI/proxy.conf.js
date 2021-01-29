const PROXY_CONFIG = [
  {
    context: [
      "/api/projects",
      "/api/projects/all",
      "/api/projectsByName",
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
