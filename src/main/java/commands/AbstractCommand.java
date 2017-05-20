package commands;

import data.Constants;
import exceptions.BadUseCommandException;
import exceptions.NotUsableInMPException;
import sx.blah.discord.handle.obj.IMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by steve on 14/07/2016.
 */
public abstract class AbstractCommand implements Command {

    protected Pattern name;
    protected Pattern pattern;
    protected Matcher m;
    protected boolean isPublic;

    protected AbstractCommand(Pattern name, Pattern pattern){
        super();
        this.name = name;
        this.pattern = pattern;
        this.isPublic = true;
    }

    @Override
    public boolean request(IMessage message) {
        m =  pattern.matcher(message.getContent());
        boolean isFound = m.find();
        if (isPublic()) {
            if (isFound && message.getChannel().isPrivate() && !isUsableInMP())
                new NotUsableInMPException().throwException(message, this);
            else if (!isFound && message.getContent().startsWith(Constants.prefixCommand + name.pattern()))
                new BadUseCommandException().throwException(message, this);
        }
        else if (! isPublic() && ! message.getAuthor().getStringID().equals(Constants.author))
            return false;
        return isFound && (isUsableInMP() || ! message.getChannel().isPrivate());
    }

    @Override
    public Pattern getName() {
        return name;
    }

    @Override
    public Pattern getPattern() {
        return pattern;
    }

    @Override
    public void setPublic(boolean isPublic){
        this.isPublic = isPublic;
    }

    @Override
    public boolean isPublic(){ return isPublic; }
}
