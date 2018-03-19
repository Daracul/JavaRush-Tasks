package com.javarush.task.task21.Expirience;

/**
 * Created by amalakhov on 17.04.2017.
 */
class Ordinary {}

// Переопределяется clone, но не реализуется
// интерфейс Cloneable:
class WrongClone extends Ordinary {
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); // Возвращает исключительную ситуацию
    }
}

// Соблюдены все необходимые для клонирования условия:
class IsCloneable extends Ordinary implements Cloneable {
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

// Клонирование отключено с генерацией исключительного события:
class NoMore extends IsCloneable {
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}

class TryMore extends NoMore {
    public Object clone() throws CloneNotSupportedException {
        // Вызов NoMore.clone(), что приводит к появлению исключительного события:
        return super.clone();
    }
}

class BackOn extends NoMore {
    private BackOn duplicate(BackOn b) {
        // Создается и возвращается копия b.
        // Это простейшее копирование, использованное лишь в качестве примера:
        return new BackOn();
    }
    public Object clone() {
        // Метод NoMore.clone() не вызывается:
        return duplicate(this);
    }
}

// Не удается наследовать, а потому и переопределить
// метод clone как это было сделано в BackOn:
final class ReallyNoMore extends NoMore {}

public class CheckCloneable {
    static Ordinary tryToClone(Ordinary ord) {
        String id = ord.getClass().getName();
        Ordinary x = null;
        if(ord instanceof Cloneable) {
            try {
                System.out.println("Попытка клонирования " + id);
                x = (Ordinary)((IsCloneable)ord).clone();
                System.out.println("Клонирован " + id);
            } catch(CloneNotSupportedException e) {
                System.err.println("Не удается клонировать "+id);
            }
        }
        return x;
    }
    public static void main(String[] args) {
        // Подмена типов:
        Ordinary[] ord = {new IsCloneable(), new WrongClone(), new NoMore(), new TryMore(), new BackOn(), new ReallyNoMore(),};
        Ordinary x = new Ordinary();
        // Это не удастся откомпилировать, пока clone()
        // описан как protected в классе Object:
        //! x = (Ordinary)x.clone();
        // tryToClone() сначала осуществляет проверку чтобы
        // определить, реализует ли данный класс интерфейс Cloneable:
        for(int i = 0; i < ord.length; i++)
            tryToClone(ord[i]);
    }
}
