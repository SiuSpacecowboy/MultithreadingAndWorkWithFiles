package workWithFiles.workWithJSON;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/** lombok позволяет избежать генерирования разного рода сеттеров, гетеров и т.д.
 * Очень удобная библиотека */
@Getter
@Setter
public class RpgJSON {
    private Classes classes;
    private Weapons weapons;

    @Setter
    @Getter
    public class Classes {
        private Knight knight;
        private Archer archer;
        private Assassin assassin;
        private Mage mage;

        @Setter
        @Getter
        public class Knight {
            private String speed;
            private String armor;
            private String range;
        }

        @Setter
        @Getter
        public class Archer {
            private String speed;
            private String armor;
            private String range;
        }

        @Setter
        @Getter
        public class Assassin {
            private String speed;
            private String armor;
            private String range;
        }

        @Setter
        @Getter
        public class Mage {
            private String speed;
            private String armor;
            private String range;
        }
    }

    @Setter
    @Getter
    public class Weapons {
        private List<String> rangedWeapon;
        private List<String> knifesAndCathars;
        private List<String> staves;
        private List<String> swords;
    }
}
