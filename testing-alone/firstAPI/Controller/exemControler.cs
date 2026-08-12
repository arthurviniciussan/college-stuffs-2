using Microsoft.AspNetCore.Mvc;

namespace firstAPI.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class exemController : ControllerBase
    {
        [HttpGet]
        public IActionResult Get()
        {
            return Ok("The first API is working");
        }
    }
}