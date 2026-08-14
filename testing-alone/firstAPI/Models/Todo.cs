namespace firstAPI.Models;
public class Todo
{
    public int ID { get; set; }
    public string Title { get; set; }
    public string Description  { get; set; }
    public DateTime Datacriado { get; set; }

    public Todo(int id, string title, string description, DateTime datacriado)
    {
        ID = id;
        Title = title;
        Description = description;
        Datacriado = datacriado;
    }
}