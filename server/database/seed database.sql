USE menagerie_network;

-- Seed Animal table data
INSERT INTO `menagerie_network`.`animal`
(`common_name`, `scientific_name`, `order`,`family`,
`genus`, `species`, `origin`, `image_url`, `description`)
VALUES
("Royal Python", "Python Regius", "Squamata", "Pythonidae", "Python", "Regius", "Africa", "/media/animals/royal-python.jpg", "The royal python, also known as the ball python, is a python species found in sub-Saharan Africa. Like all other pythons, it is a non-venomous constrictor. This is the smallest of the African pythons and is popular in the pet trade, largely due to its small size and typically docile temperament."),

("Chimpanzee", "Pan Troglodytes", "Primates", "Hominidae", "Pan", "Troglodytes", "Africa", "/media/animals/chimpanzee.jpg", "The Chimpanzee is a species of ape that is natively found in a variety of different habitats in western and central Africa. Closely related to other great apes including Orang-Utans and Gorillas, the Chimpanzee is also very closely related to Humans as we share 98% of the same DNA. They are thought to be the most intelligent animals on the planet after people and are not only known to show emotion but they are also great problem-solvers. There are two different species of Chimpanzee which are the Common Chimpanzee and the smaller Bonobo (also known as the Pygmy Chimpanzee) which has a limited distribution south of the Congo River."),

("African Lion", "Panthera Leo", "Carnivora", "Felidae", "Panthera", "Leo", "Africa", "/media/animals/african-lion.jpg", "The Lion is one of the largest, strongest and most powerful felines in the world second only in size to the Siberian Tiger. They are the largest cats on the African continent and are unique among felines in a number of ways but the biggest difference between Lions and other cats is that they are incredibly sociable animals that live together in family groups known as prides. Lions are also part of the big cat family meaning that both males and females are able to roar. Despite having once roamed across much of Africa and even parts of Europe and Asia, the world's remaining Lion population now resides in sub-Saharan Africa."),

("Bengal Tiger", "Panthera Tigris Tigris", "Carnivora", "Felidae", "Panthera", "Tigris", "Asia", "/media/animals/bengal-tiger.jpg", "The Bengal tiger (also known as the Royal Bengal tiger) is a subspecies of tiger, found across the Indian subcontinent. The Bengal tiger is the national animal of Bangladesh and is considered to be the second largest tiger in the world. The Bengal tiger is the most numerous species of tiger in Asia and is found in dense forests and mangrove swamps and jungles throughout India, Bangladesh, Bhutan and Nepal, although the Bengal tiger's range today is much smaller than it once was."),

("Emperor Penguin", "Aptenodytes Forsteri", "Sphenisciformes", "Spheniscidae", "Aptenodytes", "Forsteri", "Antarctica", "/media/animals/emperor-penguin.jpg", "The Emperor Penguin is found on and around the Antarctic continent and is not just the largest species of penguin in the world but also one of the most unique. Instead of breeding in the warmer summer months like other penguin species, Emperor Penguins lay and incubate their eggs during the coldest time of year in the coldest place on Earth. Emperor Penguins are flightless birds that have small, stiff wings that help them to fly through the water, rather than through the air. Despite having been first recorded by Captain Cook on his second voyage in the late 1700s, the first Emperor Penguin colony wasn't discovered until 1902 with their extreme southerly-dwelling nature leading to new colonies still being recorded as late as 1986."),

("Bonobo", "Pan Paniscus", "Primates", "Hominidae", "Pan", "Paniscus", "Africa", "/media/animals/bonobo.jpg", "The bonobo is a large species of primate that is only found in the Democratic Republic Of The Congo in central Africa. The bonobo is also known as the pygmy chimpanzee and the dwarf chimpanzee as the bonobo is thought to be very closely related to the chimpanzee and the two species share very similar characteristics. The bonobo is thought to have evolved from the ancestors of the common chimpanzee millions of years ago when the Congo River was formed. Today, the bonobo lives south of the Congo river and chimpanzees live north of the river meaning that they have evolved as two separate species."),

("Chinese Box Turtle", "Cuora Flavomarginata", "Testudines", "Geoemydidae", "Cuora", "Flavomarginata", "Unknown", "/media/animals/chinese-box-turtle.jpg", "These inquisitive little chelonians, also called snake eating turtles, Yellow Margined box turtles, and Golden-headed box turtles.  These turtles are native to the sub-tropical and temperate climates of China , Taiwan , and Japan and have a unique hinge on their plastron that allows box turtles to withdraw their arms, legs, and head fully into their shells and seal up like a box. These animals can stay in this position for hours. These turtles reach a shell size of 5-12 inches long."),

("Asian Elephant", "Elephas Maximus", "Proboscidea", "Elephantidae", "Elephas", "Maximus", "Southeast Asia", "/media/animals/asian-elephant.jpg", "Asian Elephants are much smaller than the African elephants only growing to a couple of meters tall. Asian elephants are found in the tropical jungles of India and China, and throughout most countries in south-east Asia. Asian elephants have been domesticated for hundreds of years for foresting and often battle. There are many places across Asia where Asian elephants are kept for tourists to ride, and are often treated fairly badly. Asian elephants are well known for their immense strength and friendliness towards humans.");

-- ////////////////////////////////////////

-- Seed Zoo table data
INSERT INTO `menagerie_network`.`zoo`
(`name`, `site_url`, `latitude`, `longitude`, `postcode`, `thumbnail_url`, `summary`)
VALUES
("Blackpool Zoo", "http://www.blackpoolzoo.org.uk", 53.816246, -3.011160, "FY3 8PP", "/media/zoos/blackpool.jpg", "Ever fancied feeding a tiger or tickling a tapir's tummy? Our animal experiences are a fantastic opportunity to get up close and personal with some incredible animals, whether you're helping to feed them or talking on the role of zoo keeper for a day."),

("Edinburgh Zoo", "http://www.edinburghzoo.org.uk", -55.942175, -3.269330, "EH12 6TS", "/media/zoos/edinburgh.jpg", "Ever fancied feeding a tiger or tickling a tapir's tummy? Our animal experiences are a fantastic opportunity to get up close and personal with some incredible animals, whether you're helping to feed them or talking on the role of zoo keeper for a day."),

("Kingston Zoo", "http://www.kingston.ac.uk", 51.403603, -0.303575, "KT1 2EE", "/media/zoos/kingston.jpg", "Ever fancied feeding a tiger or tickling a tapir's tummy? Our animal experiences are a fantastic opportunity to get up close and personal with some incredible animals, whether you're helping to feed them or talking on the role of zoo keeper for a day."),

("Welsh Mountain Zoo", "http://www.welshmountainzoo.org", 53.293110, -3.746531, "LL28 5UY", "/media/zoos/welsh-mountain.jpg", "Ever fancied feeding a tiger or tickling a tapir's tummy? Our animal experiences are a fantastic opportunity to get up close and personal with some incredible animals, whether you're helping to feed them or talking on the role of zoo keeper for a day."),

("Bristol Zoo", "http://www.bristolzoo.org.uk", 51.463763, -2.622540, "BS8 3HA", "/media/zoos/bristol.jpg", "Ever fancied feeding a tiger or tickling a tapir's tummy? Our animal experiences are a fantastic opportunity to get up close and personal with some incredible animals, whether you're helping to feed them or talking on the role of zoo keeper for a day."),

("Paignton Zoo", "http://www.paigntonzoo.org.uk", 50.428828, -3.584027, "TQ4 7EU", "/media/zoos/paignton.jpg", "Ever fancied feeding a tiger or tickling a tapir's tummy? Our animal experiences are a fantastic opportunity to get up close and personal with some incredible animals, whether you're helping to feed them or talking on the role of zoo keeper for a day.");


-- ////////////////////////////////////////

-- Finally seed Zoo Animal table data
INSERT INTO `menagerie_network`.`zoo_animal`
(`animal_id`, `zoo_id`, `pet_name`, `age_months`, `male`)
VALUES
-- Royal Pythons at Blackpool
(1, 1, "Slimy", 14, 1),
(1, 1, "Slither", 11, 0),
(1, 1, "Belka", 26, 1),
-- Royal Pythons at Edinburgh
(1, 2, "Chowder", 6, 0),
(1, 2, "Diablo", 1, 0),
-- Royal Pythons at Kingston
(1, 3, "Dragar", 19, 1),

-- Chimpanzees at Blackpool
(2, 1, "Nimo", 24, 1),
(2, 1, "Edna", 13, 0),
-- Chimpanzees at Kingston
(2, 3, "Bubbles", 31, 1),
(2, 3, "Koko", 28, 0),

-- Lions at Bristol
(3, 5, "Simba", 48, 1),
(3, 5, "Sarafina", 31, 0),
(3, 5, "Leta", 29, 0),
(3, 5, "Saria", 39, 0),
-- Lions at Paignton
(3, 6, "Fred", 14, 1),
(3, 6, "Mufasa", 25, 1),
(3, 6, "Nala", 22, 0),

-- Bengal Tigers at Welsh Mountain
(4, 4, "Saber", 58, 1),
(4, 4, "Woody", 37, 0),
(4, 4, "Felice", 22, 0),

-- Penguins at Welsh Mountain
(5, 4, "Happy Feet", 16, 1),
(5, 4, "Chinny", 12, 0),
-- Penguins at Edinburgh
(5, 2, "Chop", 11, 0),
(5, 2, "Clumbsy", 9, 0),

-- Bonobo at Kingston
(6, 3, "Timber", 14, 1),
(6, 3, "Janice", 12, 1),
-- Bonobo at Blackpool
(6, 1, "Speedy", 21, 1),
(6, 1, "Greedy", 17, 0),
-- Bonobo at Welsh Mountain
(6, 4, "Peter", 9, 0),
(6, 4, "Naughty", 11, 0),

-- Turtles at Paignton
(7, 6, "Spud", 26, 1),
(7, 6, "Flipper", 48, 0),

-- Elephants at Bristol
(8, 5, "Lucy", 112, 1),
(8, 5, "Trunky", 240, 0),
(8, 5, "Tusky", 24, 1),
(8, 5, "Belle", 183, 0);


-- ////////////////////////////////////////

-- Seed admin user
INSERT INTO `menagerie_network`.`user`
(`email`, `password_hash`, `password_salt`,`role`)
VALUES
("email@email.com", 
"NkWw4Voo24ASA05PMC1RJBPsmjmdIwiVAc8xbU9dbwiv6d6+kfoN70vfmTQdqcDSO72aWqZIXmWdOVUksm7Vwg==",
"83GXr6Jnj5Bq3+5QlHFzyw==",
"admin";