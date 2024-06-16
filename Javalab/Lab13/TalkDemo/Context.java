package TalkDemo;

public class Context {
    private Talk talk;
    
    public Context(Talk talk)
    {
        this.talk = talk;
    }

    public String executeTalk (String voice){
        return talk.doOperation(voice);
    }
}
