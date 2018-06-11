package com.example.android.guiatour.Adapter;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import com.example.android.guiatour.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PaisAdapter extends AppCompatActivity{

    Toolbar toolbar;
    ImageView imgBandeira, imgTurismo;

    private ExpandableListView listView;
    private ListaExpansivaAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pais);

        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        imgBandeira = (ImageView) findViewById(R.id.imgBandeira);
        imgTurismo = (ImageView) findViewById(R.id.imgTurismo);
        listView = (ExpandableListView) findViewById(R.id.lvExp);


        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            toolbar.setTitle(bundle.getString("Paises"));

            if(toolbar.getTitle().toString().equalsIgnoreCase("Brasil")){

                imgBandeira.setImageDrawable(ContextCompat.getDrawable(PaisAdapter.this,
                        R.drawable.ban_brasil));
                imgTurismo.setImageDrawable(ContextCompat.getDrawable(PaisAdapter.this,
                        R.drawable.turis_brasil));

                listDataHeader = new ArrayList<>();
                listHash = new HashMap<>();

                listDataHeader.add("Introdução");
                listDataHeader.add("Antes de Viajar");
                listDataHeader.add("O que levar");
                listDataHeader.add("Curiosidades");
                listDataHeader.add("Pontos Turisticos");

                List<String> introducao = new ArrayList<>();
                introducao.add("País da Miscigenação, do Samba, do Carnaval, das praias e um dos países com os melhores cenários do mundo. Grande, muito grande, saiba aqui a melhor forma de explorar esse Gigante da Natureza e aproveitar o melhor que ele tem para oferecer! ");

                List<String> antesViagem = new ArrayList<>();
                antesViagem.add("Visto é o documento concedido pelas Representações Consulares do Brasil no exterior que possibilita a expectativa de ingresso e estada de estrangeiros no território nacional, desde que satisfeitas às condições previstas na legislação vigente.\n" +
                        "Para solicitar o visto, o cidadão de outros países deverá apresentar Formulário de Pedido de Visto devidamente preenchido, documento de viagem válido, comprovante de pagamento dos emolumentos consulares, Certificado Internacional de Imunização - quando necessário -, e demais documentos específicos para o tipo de visto solicitado.\n");

                List<String> Oquelevar = new ArrayList<>();
                Oquelevar.add("Bem como o seu kit de viagem habitual, estes são alguns extras que você pode querer levar junto com você:\n" +
                        "\n" +
                        "- Moeda Local: O Brasil é um país caro, muito caro. Para os turistas de primeira viagem é aconselhável se atentar muito quando o assunto for quanto dinheiro levar, seja pelos preços das mercadorias, os custos burocráticos e o “preço especial para turista”, se preparem para serem taxados em tudo que possam imaginar.\n" +
                        "-Chip de Celular: Para quem não abre mão de ter um celular ligado e acesso a internet pelo telefone o tempo todo, o Brasil não é um bom destino. Aqui a internet não é muito bem distribuída, sendo também muito cara. Por mais que haja muitos estabelecimentos com Wi-Fi, você encontrará muitos problemas, sejam eles lentidão, latência, problemas de infra, e outros mais.\n" +
                        "\n" +
                        "-Vacina: Dependendo do seu destino, é recomendável a vacinação para várias doenças, principalmente em regiões de mata densa e regiões menos desenvolvidas, a diversidade natural é muito bonita, mas é preciso estar bem protegido sempre para melhor aproveitá-la.\n" +
                        "\n" +
                        "-Tomada: A voltagem padrão em todo o país é 110 volts, mas cuidado que existem muitas tomadas de 220 volts também, é recomendado sempre checar a voltagem das tomadas antes de plugar qualquer dispositivo. Dependendo do seu destino, recomendamos não plugar nada, uma vez que a energia no país não é bem distribuída e em locais mais afastados você pode se deparar com altas variações de corrente, que pode estragar seu aparelho.\n" +
                        "\n" +
                        "-Código de vestimenta: Biquínis, sungas, pessoas sem camisa, no Brasil não existe muitas restrições quanto ao código de vestimenta, mas não pense que por causa disso você pode andar pelado na rua, existem leis e regras como em qualquer lugar, da mesma forma que você não poderá andar pelado na rua (mas poderá frequentar praias de nudismo)  você não entrará em um restaurante fino de sunga (A não ser que seja um restaurante na orla). De qualquer forma, recomendamos roupas mais leves e frescas, pois na maior parte dos estados se faz muito calor.");

                List<String> curiosidades = new ArrayList<>();
                curiosidades.add("\n" +
                        "-O idioma oficial é o português, e é recomendado saber algumas palavras chaves para comunicação. O povo brasileiro é um povo bem carinhoso e preocupado, se você passar por uma emergência muitos tentarão ajudar, mas o nível de inglês aqui é péssimo, então é sempre bom tentar aprender algumas frases para evitar situações constrangedoras.\n" +
                        "\n" +
                        "- O país é muito grande, mas não tem linhas de trem interligando-o, só rodovias para carros, rodovias essas mal cuidadas e cheias de buracos, sem falar no alto custo do pedágio e fiscalizações eletrônicas com multas salgadas, ou seja, não recomendamos um passeio de estrada. Se deseja visitar outro estado, recomendamos os aeroportos, por mais que sejam bem salgados ainda são um melhor custo benefício considerando o conforto e o fato de ainda não terem inventado um sistema de multas para aviões.\n" +
                        "\n" +
                        "- A culinária brasileira é uma das mais diversificadas. Comida Árabe, Japonesa, Junk food, Culinária Italiana, Francesa e a clássica Feijoada bem brasileira. Você não terá muitos problemas para encontrar uma boa comida, com tantos povos diferentes em um só país a diversificação na cozinha acaba sendo natural. Só cuidado com o preço, afinal é tudo muito caro.");

                List<String> pontosTuristicos = new ArrayList<>();
                pontosTuristicos.add("\n" +
                        "Corcovado (Cristo Redentor)\n" +
                        "\n" +
                        "Um dos principais pontos turísticos do Rio de Janeiro: O Cristo Redentor.\n" +
                        "Quando pensamos no Rio de Janeiro logo vem à nossa cabeça a imagem do Cristo Redentor, estou certo? Eleito uma das Sete Maravilhas do Mundo Moderno, sem dúvida ele é o principal cartão postal carioca.\n" +
                        "A estátua de 30m de altura fica no alto do morro do Corcovado (Floresta da Tijuca), a 700 metros de altitude e com uma vista de tirar o fôlego. Lá de baixo ele é visto quase da cidade toda, compondo a paisagem.\n" +
                        "Pouca gente sabe, mas o rosto da estátua foi criado pelo escultor Gheorghe Leonida, que nasceu na Romênia em 1893. Outro ponto em comum com o Brasil, é que o idioma romeno também tem como base o latim.\n" +
                        "\n" +
                        "Pão de Açúcar\n" +
                        "\n" +
                        "Esse teleférico parte da Praia Vermelha, faz uma parada no alto do Morro da Urca e, por fim, segue viagem rumo ao Morro do Pão de Açúcar.\n" +
                        "A vista privilegiada da Baia de Guanabara, da Enseada de Botafogo, e de algumas praias da Zona Sul são a recompensa do passeio. Se você puder, vale muito a pena ir para curtir o pôr-do-sol lá de cima.\n" +
                        "O bondinho proporciona um cenário em 360 graus e para onde quer que se olhe existe um cartão postal da cidade maravilhosa. Dá para curtir o visual das praias do Leme, Copacabana, Ipanema, Flamengo e Leblon.\n" +
                        "Além de ver a Pedra da Gávea, o Corcovado, o centro, o Aeroporto Santos Dumont, a Ilha do Governador, Niterói e sua ponte e até a Serra do Mar, com seu imponente “Dedo de Deus”.\n" +
                        "\n" +
                        "Arpoador\n" +
                        "\n" +
                        "Localizado em Ipanema, a Pedra e a Praia do Arpoador são um dos pontos turísticos mais visitados no Rio de Janeiro. Sua praia, com apenas 500 metros de extensão, é frequentada principalmente por surfistas por causa das ondas constantes.\n" +
                        "Minha sugestão é: não deixe de subir na pedra. Dela, temos uma ótima vista das Praias de Ipanema e do Leblon, e ainda do Morro dos Irmãos. Além disso, o Arpoador é um dos melhores lugares para se curtir o pôr-do-sol no Rio de Janeiro!\n" +
                        "\n" +
                        "\n" +
                        "Porto de Galinhas\n" +
                        "\n" +
                        "Enfim, esta praia é um destino de felicidade certa. Lá você encontra a diversão que precisa para que as suas férias sejam as melhores possíveis, seja com os amigos ou com a família. Porto de Galinhas é um destino que fará você conhecer a verdadeira beleza do Brasil. Monte seu tour turístico e visite a praia mais bonita do Brasil.\n" +
                        "\n" +
                        "Jardim Botânico\n" +
                        "Palácio de vidro durante fim de tarde no Jardim Botânico de Curitiba.\n" +
                        "O cartão postal mais famoso de Curitiba é, sem dúvida, o Jardim Botânico. Sendo assim, é visita obrigatória para qualquer viajante! Famoso por sua estufa de vidro (inspirada no Palácio dos Cristais de Londres), e pelos jardins geométricos, ele funciona como centro de pesquisas da flora do Paraná e contribui para a preservação e conservação da natureza, o que é fundamental para a educação ambiental na cidade. Além, claro, de ser um espaço de lazer para toda a população.\n" +
                        "O Jardim Botânico funciona de segunda-feira a domingo, no verão, das 6 às 20 horas e, no inverno, das 6 às 19:30 horas e a entrada é franca. Prepare a câmera para tirar lindas fotos no espaço e permita-se ficar um bom tempo nele.\n" +
                        "\n" +
                        "Teatro Ópera de Arame\n" +
                        "\n" +
                        "O Teatro Ópera de Arame é outro ponto turístico famoso da capital paranaense. Com capacidade para mais de 1.500 pessoas, ele foi construído todo em metal, com paredes transparentes, sobre um lago. Além do monumento (que é um espetáculo) o espaço funciona como uma espécie de parque. No lago, há vários peixes e patinhos e uma queda d’água, como um mini-cachoeira enche os olhos dos visitantes.\n" +
                        "Bem ao seu lado está a Pedreira de Paulo Leminski, uma antiga pedreira desativada que hoje é importante palco cultural de Curitiba, espaço destinado a receber espetáculos ao ar livre. A entrada para o Teatro Ópera de Arame é gratuita, exceto se estiver acontecendo algum evento específico.\n" +
                        "\n" +
                        "Museu Oscar Niemeyer\n" +
                        "\n" +
                        "Museu do Olho, obra de Oscar Niemeyer.\n" +
                        "Outro ponto importante na cidade é o Museu Oscar Niemeyer. Mais conhecido como Museu do Olho, devido ao formato de sua construção. Esse espaço abriga exposições fixas e temporárias. Além disso, seus jardins são um ótimo ambiente para fazer piqueniques, cena comum de se ver nos finais de semana de sol.\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "As principais praias de Fortaleza\n" +
                        "\n" +
                        "Praia do Futuro: a mais afastada da área urbana, é a mais procurada por banhistas e surfistas. Devido aos ventos fortes que sopram na região, cuidado com as ondas, que geralmente são altas e fortes. A Praia do Futuro ficou famosa devido às barracas muito bem estruturadas que se instalaram ali; não é difícil encontrar shows de música no fim de tarde;\n" +
                        "Iracema: é o local onde os festeiros se reúnem para curtir a noite. Conhecida como a “Praia dos Boêmios”, começa a ter movimento ao entardecer e vai até a madrugada. São diversos bares, restaurantes e boates, incluindo o Pirata. Não deixe de conhecer o Centro Dragão do Mar de Arte e Cultura, um espaço cultural que possui teatro, cinema, espaço para shows e galerias de arte;\n" +
                        "Mucuripe: é a praia dos jangadeiros. Não deixe de fazer um passeio de jangada durante o por-do-sol. É uma oportunidade única para ter uma visão especial da cidade de Fortaleza;\n" +
                        "Praia do Meireles: é onde está concentrada a maior parte das pousadas e hotéis de Fortaleza. Aproveite para fazer uma caminhada no calçadão e conhecer a feira de artesanato, que funciona todos os dias a partir do entardecer.\n" +
                        "Canoa Quebrada: é uma das praias mais famosas do Brasil. Faz parte da Costa do Sol Nascente, com 200 km de praias, à leste de Fortaleza. As falésias, jangadas, passeios de buggy, esportes náuticos e agitada vida noturna, fazem de Canoa Quebrada, com sua ótima estrutura de hotéis e pousadas, uma praia com a combinação perfeita para atrair viajantes;\n" +
                        "Morro Branco: a 60 km de Canoa Quebrada, possui lindas paisagens e certamente merece uma visita;\n" +
                        "Jericoacoara: está localizada na Costa do Sol Poente, com 400 km de praias, à oeste de Fortaleza. Considerada como uma das 10 praias mais bonitas do mundo, Jeri é um lugar fora de série por diversos motivos: o charme e astral da vila, a Lagoa Azul com sua águas transparentes, a Pedra Furada e as dunas, local muito procurado para aproveitar o por-do-sol. Guarde boa parte dos seus dias para esse pedaço de paraíso. Fiquei uma semana e voltei com saudades de lá.\n" +
                        "\n" +
                        "Mavsa Resort\n" +
                        "\n" +
                        "O hotel disponibiliza inúmeras atrações para todos os gostos e faixas etárias, além de oferecer um ótimo atendimento, conforto e tranquilidade, numa área de 55 mil metros quadrados. A estrutura do resort conta com apartamentos e chalés divididos em cinco categorias, agradando até mesmo o hóspede mais exigente.\n" +
                        "As principais atrações são as piscinas com seu tobogã, os monitores especialistas na recreação da criançada, tirolesa, arvorismo, arco e flecha, caiaque, pedalinho, stand up paddle, quadra poliesportiva, futebol de campo, mini zoo, bares, restaurantes, pesca, academia, espaço zen e a fantástica cidade dos sonhos, espaço recém inaugurado com brinquedos, playground, jogos de mesa e até um cinema para as crianças.\n" +
                        "\n" +
                        "\n" +
                        "Mercado Municipal\n" +
                        "\n" +
                        "Para quem gosta de conhecer as raízes de cada lugar, seguramente sabe que o mercado municipal é a melhor opção. No mercadão de São Paulo não é diferente. Se deliciar com os famosos sanduiches de mortadela e pastel de bacalhau são clássicos do turismo na cidade.\n" +
                        "Se pretende ir de carro, chegue cedo para evitar o tumulto no estacionamento e o mercado muito cheio. É costume dos comerciantes oferecerem amostras dos queijos, azeitonas e diversas outras comidas. Como o mercado é grande, aproveite para passear pelos corredores e provar de tudo. Tome um chopp aqui, outra cerveja ali e continue provando. Quando lembrar que ainda não almoçou, já terá perdido a fome!!! E ainda tem o corredor dos doces e chocolates!!!\n" +
                        "\n" +
                        "\n" +
                        "Praça Benedito Calixto\n" +
                        "Nesta famosa praça localizada no bairro de Pinheiros acontece a Feira de Artes, Cultura e Lazer. O evento acontece aos sábados, das 09 às 19hs. São cerca de 320 expositores que oferecem obras de arte, artesanato e antiguidades, além de alguns bares e restaurantes.\n" +
                        "O passeio pode ocupar 2 ou 3 horas do seu dia. Como o bairro é bem localizado e próximo a Vila Madalena, aproveite para conhecer esse outro bairro, que é um dos mais agitados da cidade de São Paulo, com uma infinidade de bares e dezenas de paredes pintadas com grafite.\n" +
                        "\n" +
                        "\n" +
                        "A Vila Madalena\n" +
                        "\n" +
                        "Este charmoso bairro é provavelmente o mais frequentado pelos jovens. Na minha opinião os bares, baladas e diversas paredes e becos grafitados transformam o bairro no mais atrativo da cidade. Existem agências especializadas que trazem gringos só para conhecer os grafites.\n" +
                        "\n" +
                        "\n" +
                        "A Praia da Graciosa\n" +
                        "\n" +
                        "Quem disse que não existem praias no interior do Brasil??? Pois é, a Praia da Graciosa é uma das provas disso. Moradores e turistas têm a chance de se refrescar no principal rio do município, mas num trecho que faz parte do lago da Usina Hidrelétrica de Lajeado, localizada 54 km ao norte de Palmas.\n" +
                        "\n" +
                        "As águas escuras e frescas do Rio Tocantins abrigam as temidas piranhas, que segundo lendas locais, já mataram adultos e crianças que nadavam por ali. Difícil acreditar, mas para segurança de moradores e turistas foram colocadas cercas nas áreas destinadas aos banhistas.\n" +
                        "Minha passagem por aqui foi rápida, apenas para tirar algumas fotos e tomar uma cerveja enquanto negociava o preço da viagem de barco no Porto da Praia, com destino a Ilha da Canela. Nesse pouco tempo já pude perceber porque é um dos lugares mais populares de Palmas, que aliás é uma das que possui melhores IDH do Brasil.\n" +
                        "\n" +
                        "\n" +
                        "Circuitos Salvador\n" +
                        "\n" +
                        "Campo Grande / Osmar: é o maior circuito, que pode durar até 8 horas. Ele da a volta inteira no centro antigo de Salvador, tendo a praça Castro Alves como ponto mais alto…aliás a vista é incrível. Se tiver pique, faça a volta inteira e aproveite. Muitas mulheres pedem uma “carona” aos cordeiros logo após a Castro Alves, para conseguirem um taxi. Eles cobram cerca de R$ 10,00.\n" +
                        "Barra Ondina / Dodo: este circuito é mais curto e possui mais vias de acesso / saída. É na avenida beira-mar, mais arejado e perto dos melhores camarotes. Prefiro de longe o Barra Ondina.\n" +
                        "\n" +
                        "\n" +
                        "Morro de São Paulo\n" +
                        "\n" +
                        "Rasta e Viviane estão morando há 16 anos na Bahia e sabem muito bem o que fazer em Morro de Sao Paulo. Veja algumas dicas de passeios imperdíveis:\n" +
                        "Caminhadas ao Forte e ao Farol: esses são os dois monumentos mais importantes da Ilha. Do Farol é possível avistar todas as praias da vila. Já o Forte é onde a galera se reúne para assistir o belíssimo pôr-do-sol. O passeio é o mais indicado para o final da tarde;\n" +
                        "Mergulho nas águas cristalinas: com snorkel a pedida são a Terceira e Quarta praias e a piscina natural de Moreré, na vizinha Ilha de Boipeba. De cilindro, as opções são Gamboa Velha e os corais de Itatiba e Itatimirim;\n" +
                        "Curtir o por do sol na Toca do Morcego: nas terças e sábados ao entardecer, o local com vista para o mar ganha almofadas, esteiras e redes distribuídas por um belo jardim e uma excelente trilha sonora;\n" +
                        "Curtir a Vida noturna: até a meia-noite, o movimento acontece nos restaurantes da vila. A noite em Morro de São Paulo acontece na areia, com animados luaus na Segunda Praia;\n" +
                        "Comprar artesanato: todas as noites é montada na Praça Aureliano Lima uma feirinha com artigos em prata, bijuterias e objetos de decoração.\n" +
                        "\n" +
                        "\n" +
                        "Mini Mundo\n" +
                        "Cidades em miniatura no Mini Mundo.\n" +
                        "Separe no mínimo uma hora para se divertir no Mini Mundo em Gramado. Aqui você encontrará literalmente um mini-mundo, com 140 construções 24 vezes menor que o comum, com representações de Bariloche, Alemanha e outros lugares ao redor do planeta.\n" +
                        "São árvores, pessoas, meios de transporte, casas, igrejas, bombeiros, estações de trem, palácios, aeroportos e tudo que você puder imaginar que exista numa cidade. Tudo isso com detalhes minuciosos, criados com muita perfeição. Mas não para por aí, dentro do parque também existem outros espaços em tamanho normal, como loja de presentes, espaços lúdicos, parquinhos infantis, cafés e fraldário. A entrada para adultos custa R$ 24,00, para crianças de 2 à 12 anos o valor é R$ 15,00 e menores de 2 anos a entrada é gratuita. Abre das 9h15 às 17h.\n");
                listHash.put(listDataHeader.get(0),introducao);
                listHash.put(listDataHeader.get(1),antesViagem);
                listHash.put(listDataHeader.get(2),Oquelevar);
                listHash.put(listDataHeader.get(3),curiosidades);
                listHash.put(listDataHeader.get(4),pontosTuristicos);
            }

            else if(toolbar.getTitle().toString().equalsIgnoreCase("Estados Unidos")){
                imgBandeira.setImageDrawable(ContextCompat.getDrawable(PaisAdapter.this,
                        R.drawable.ban_estadosunidos));
                imgTurismo.setImageDrawable(ContextCompat.getDrawable(PaisAdapter.this,
                        R.drawable.turis_estadosunidos));


                listDataHeader = new ArrayList<>();
                listHash = new HashMap<>();

                listDataHeader.add("Introdução");
                listDataHeader.add("Antes de Viajar");
                listDataHeader.add("O que levar");
                listDataHeader.add("Curiosidades");
                listDataHeader.add("Pontos Turisticos");

                List<String> introducao = new ArrayList<>();
                introducao.add("Pode parecer mais simples preparar uma viagem para os Estados Unidos, afinal há tanta informação disponível sobre o país, que muitos turistas acabam deixando o planejamento para depois. Porém, um país tão grande e cheio de diversidades, merece bastante de nossa atenção.\n" +
                        "Nova York, Orlando, Miami, Los Angeles, San Francisco, San Diego…são inúmeras cidades e destinos turísticos para visitar e cada um com sua especificidade. Por isso, é bom ter atenção a cada detalhe para não sair nada errado com sua viagem. Para ajudar, separei algumas dicas aqui no blog para quem está embarcado pela primeira vez para a Terra do Tio Sam.\n");

                List<String> antesViagem = new ArrayList<>();
                antesViagem.add("Para realizar qualquer tipo de viagem para os Estados Unidos é obrigatório ter visto, e saiba que o país é muito rigoroso com a documentação. Para solicitar o visto é necessário inicialmente preencher o formulário DS-160 e logo após pagar a taxa equivalente. Com o comprovante e o código do formulário em mãos, você poderá agendar a entrevista. Na sequência, é necessário fazer a coleta dos dados biométricos e por fim a entrevista.\n" +
                        "Não existe um “roteiro” na hora da entrevista, mas ela costuma ser rápida e objetiva. Geralmente as perguntas são: “O que pretende fazer no país? ”, “Quantos dias vai ficar? ”, “Já viajou para o exterior? ”, “O que você faz no Brasil? ”, entre outras. Se aceito, o prazo médio para a entrega do visto é de 7 dias.\n" +
                        "Se o seu visto for negado, após o prazo de uma semana você pode solicita-lo novamente, mas para isso você deverá pagar uma nova taxa e comprovar que houve alguma mudança.");

                List<String> Oquelevar = new ArrayList<>();
                Oquelevar.add("Bem como o seu kit de viagem habitual, estes são alguns extras que você pode querer levar junto com você:\n" +
                        "\n" +
                        "- Dólar: maioria das pessoas que viaja para os Estados Unidos aproveita para fazer umas comprinhas, principalmente de eletrônicos, sendo sempre bom levar um pouco de dinheiro. Você consegue comprar a moeda americana facilmente em qualquer casa de câmbio ou banco no Brasil. No país são aceitas as principais bandeiras de cartões de crédito, basta ativar para utiliza-los no exterior.\n" +
                        "\n" +
                        "-Chip de Celular: Para quem não abre mão de ter um celular ligado e acesso a internet pelo telefone o tempo todo, comprar um SIM Card Internacional é sem dúvida uma das melhores opções. Mas antes de escolher um, pesquise, compare preços e principalmente, fique atento as suas necessidades, pois muitas vezes compramos pacotes, não usamos todos os seus benefícios e perdemos a chance de economizar com celular em viagem internacional.\n" +
                        "\n" +
                        "-Vacina: Não são exigidas vacinas para entrar nos Estados Unidos, mas fique de olho se seu voo tem alguma conexão. Em alguns casos, como no Panamá, dizem que a vacina contra a febre amarela é exigida mesmo para quem vai permanecer apenas algumas horas no país. Na prática, o Panamá não exige a vacina, apesar de ser altamente recomendável.\n" +
                        "\n" +
                        "-Tomada: A voltagem padrão em todo o país é 115-120 volts. Para usar aparelhos de outras voltagens é necessário um conversor ou adaptador para tomadas do tipo americano (aquelas de duas pontas chatas). Você encontra facilmente em lojas locais, mas o ideal é já viajar com um adaptador universal.\n" +
                        "\n" +
                        "-Código de vestimenta: Nem é preciso dizer que os EUA é um país de dimensões continentais. Por causa dessa extensão territorial, há uma diversidade incrível de climas. A ponta sul da Flórida é tropical, o clima é desértico no sudoeste, mediterrânico na costa da Califórnia e oceânico nas costas do Oregon e Washington. E ainda tem o Alasca, com clima sub-ártico ou polar. Então, o que levar na mala vai depender da época do ano e de quais cidades visitará.\n");

                List<String> curiosidades = new ArrayList<>();
                curiosidades.add("\n" +
                        "- Obviamente o idioma oficial é o inglês, e a boa notícia é que o inglês falado nas grandes cidades americanas é bem fácil de entender, afinal estamos acostumados a consumir bastante conteúdo americano, através de músicas, filmes e seriados. Muita gente me pergunta se é possível viajar sem falar inglês, e sempre respondo que sim.\n" +
                        "Existem aplicativos de tradução, você pode fazer mímicas e quem quiser consegue se virar. Porém, é conversando com as pessoas, principalmente os moradores locais, que na minha opinião se aproveita verdadeiramente uma viagem.\n" +
                        "\n" +
                        "- O país tem um ótimo sistema de transporte e você consegue circular entre os estados sem muitas dificuldades. O melhor meio de transporte dependerá do seu roteiro e da distância entre as cidades. Como o país é muito grande, se você for para cidades mais distantes entre si, o avião sem dúvida é o meio mais indicado. Entre as empresas mais populares estão a Allergiant, Southwest, Jetblue e Virgin Airlines.\n" +
                        "\n" +
                        "- Para quem vai viajar para os Estados Unidos e pensa que só vai encontrar fast food ou junk food, está muito enganado. Claro que o país está entre os campeões no ranking da alimentação altamente calórica, mas devido a pluralidade de pessoas que circulam por suas grandes metrópoles, e também pequenas cidades, existem restaurantes e opções para todos os gostos, inclusive para os mais naturebas! A Califórnia, em especial, possui mais opções saudáveis.");

                List<String> pontosTuristicos = new ArrayList<>();
                pontosTuristicos.add("\n" +
                        "O Grand Canyon.\n" +
                        "South Rim | A margem sul é a área com melhor infra-estrutura turística e, consequentemente, a mais visitada do Grand Canyon, recebendo 90% do público ao longo do ano. Fica a 450 km de Las Vegas e possui cerca de 10 mirantes com vistas de tirar o fôlego, e até mesmo trilhas para os turistas que prezam pelo contato com a natureza.\n" +
                        "\n" +
                        "North Rim | Apesar de estar localizada mais perto de Las Vegas, a “apenas” 400 km de distância, a margem norte é menos visitada, mas não menos atraente, sendo geralmente a opção de quem já conhece o parque e busca uma experiência menos turística. Por estar a 300 m acima do South Rim, aqui o frio é mais intenso no inverno, fator que faz esta área do parque ficar aberta apenas de maio a outubro.\n" +
                        "\n" +
                        "West Rim | Por estar na face oeste do Grand Canyon, fica a modestos 200 km distante de Las Vegas, sendo a opção mais sensata para quem pretende fazer um bate e volta de ônibus. Está área não pertence ao parque, e sim a tribo indígena Hualapai, o que permitiu a construção do Skywalk do Grand Canyon, uma passarela de vidro em forma de ferradura com 21 metros de comprimento e 1450 metros acima do nível do Rio Colorado.\n" +
                        "\n" +
                        "Inner Canyon | Para os mais aventureiros, não basta admirar as paisagens sempre coloridas do Grand Canyon. Existem diversas atividades para quem se dispõe a entrar no cânion, hafting, mountain biking, longas caminhadas e até passeios de mula até o leito do rio, obviamente sempre supervisionados por profissionais.\n" +
                        "\n" +
                        "Pool parties de Las Vegas\n" +
                        "\n" +
                        "As pool parties de Las Vegas, ou festas que acontecem nas piscinas dos principais hotéis, são um espetáculo à parte. As mais conhecidas, e aquelas que você não pode perder, acontecem no Encore Beach Club, Marquee Day Club, Palms Poll e Hard Rock Hotel. Porém, em praticamente todos os hotéis as festas são iradas.\n" +
                        "\n" +
                        "Baladas e casas noturnas de Las Vegas\n" +
                        "As baladas de Las Vegas são sensacionais, todas em excelentes espaços e sempre apresentam os melhores DJ’s, como Kaskade, Tiesto, Erick Morillo, Steve Aoki, Calvin Harris e tantos outros. É difícil saber qual a melhor opção para cada dia da semana; isso pode depender de seu gosto musical e sorte.\n" +
                        "\n" +
                        "Nos grandes hotéis, concentrados na Vegas Boulevard (ou “The Strip”), avenida que corta a cidade de ponta a ponta, também estão instalados os principais cassinos e as melhores casas noturnas de Las Vegas:\n" +
                        "\n" +
                        "The Joint  | É o melhor espaço para os grandes shows e eventos (Hard Rock Hotel);\n" +
                        "Tao Nightclub | A casa tem vários ambientes e a decoração e restaurante são atrações a parte (Venetian Hotel);\n" +
                        "Rain | Excelente decoração e efeitos especiais (Palms Cassino Resort);\n" +
                        "Marquee Nightclub | Casa noturna de um dos mais novos hotéis de Las Vegas (The Cosmopolitan);\n" +
                        "Surrender Nightclub | Uma das principais referências na noite de Vegas (Encore Hotel);\n" +
                        "XS The Nightclub | Outra excelente casa noturna que recebe os principais DJ’s de House Music (Encore Hotel);\n" +
                        "Vanity Nightclub | Mais um excelente espaço para festas do hotel (Hard Rock Hotel);\n" +
                        "Haze Nightclub | Casa noturna com 2 níveis e incríveis efeitos de luz (Aria Hotel & Cassino);\n" +
                        "Tryst Nightclub | Como todas as baladas de Las Vegas, é sempre boa opção (Wynn Hotel);\n" +
                        "Club Nikki | Uma das casas mais famosas do mundo, também em Las Vegas;\n" +
                        "Lavo | Considerado um dos melhores espaços de Las Vegas (The Palazzo).\n" +
                        "\n" +
                        "Oahu\n" +
                        "A porta de entrada para a maioria dos turistas que visitam o Havaí é a cidade de Honolulu, capital de Oahu. É a principal e mais desenvolvida cidade havaiana, com grande infra-estrutura turística, concentrada na região conhecida como Waikiki. Não espere ter uma experiência genuinamente havaiana nessa região, pois é tudo realmente muito turístico, com dezenas de lojas de marca, restaurantes chiques, grandes resorts e hotéis que são infestados por turistas japoneses.\n" +
                        "\n" +
                        "Big Island\n" +
                        "Não é a toa que a maior ilha do Hawaii é conhecida como Big Island, pois sua área é maior que todas as outras ilhas juntas. O lugar é um paraíso com belezas únicas e totalmente diferentes, palco do Iron Man de 2011, o maior triátlon do mundo.\n" +
                        "Por ser uma ilha tão grande, são dois os aeroportos que atendem os turistas, nas cidades de Kona e Hilo. Esse é um fator importante para o planejamento do roteiro de viagem, pois é possível chegar por uma cidade e sair por outra, o que economiza muito tempo com deslocamentos. No caminho é possível ver lava de um vulcão ainda ativo, visitar praias de areia verde e preta, nadar com golfinhos, fazer snorkeling e ainda conhecer a praia mais bonita do Hawaii, que é considerada um local sagrado pelos havaiano.\n" +
                        "\n" +
                        "\n" +
                        "Maui\n" +
                        "Maui é definitivamente a ilha ideal para os ratos de praia. Não que as praias sejam mais bonitas, mas é a maneira como a população gosta de viver. Como qualquer outro território dos Estados Unidos, é tudo bastante organizado, com duchas e sanitários em quase todas as praias. As cidades são bem tranquilas, o que sempre me deixava com vontade de morar por ali.\n" +
                        "Ilha de Guam\n" +
                        "Essa ilha pertencente aos Estados Unidos, saldo de suas batalhas contra o Japão na 2ª Guerra Mundial, é pouco visitada por turistas ocidentais. O clima e a natureza são incríveis, proporcionando uma viagem ideal para casais em lua de mel.\n" +
                        "\n" +
                        "Wynwood Walls\n" +
                        "Wynwood é um bairro localizado ao norte do centro que Miami, que ficou muito famoso pela instalação de galerias de arte e grafites em prédios e paredes, um lugar que definitivamente deve entrar em qualquer roteiro por Miami, mesmo que fique na cidade apenas por 2 dias.\n" +
                        "Praticamente todo o bairro tem suas paredes pintadas: lojas, cafés, prédios residenciais, baladas e até mesmo as fábricas instaladas por aqui. Porém, o centro de tudo é o famoso Wynwood Walls, um espaço onde se concentram as obras dos artistas mais famosos, além de um charmoso café e restaurante.\n" +
                        "\n" +
                        "\n" +
                        "Parques Disney e Universal\n" +
                        "São diversas opções de parques tanto no Walt Disney World quanto no Universal em Orlando, e você vai precisar de um dia inteiro para conhecer cada um. Veja as atrações de cada parque e escolha o que achar melhor para sua viagem. Uma dica é chegar bem cedo e já ir nos brinquedos mais disputados, porque os parques começam a encher depois das 10h.\n" +
                        "Empire State Building\n" +
                        "Clássico dos clássicos, o Empire State Building não é apenas mais um edifício nos céus de Nova York; é também um dos pontos turísticos mais importantes a se conhecer no país. Inaugurado em 1931, já foi considerado por algumas décadas o edifício mais alto do mundo e hoje é um ponto de parada imperdível para quem deseja admirar NY de um ângulo novo. Foi o Empire State que King Kong, o gorila gigante, escalou e é ele que aparece nas histórias do Homem Aranha. O arranha-céu é figurinha marcada nos filmes rodados na cidade e, em datas especiais, ele recebe uma iluminação comemorativa. Seu topo pode ser visto de diversos pontos da cidade - afinal, são 102 andares. \n" +
                        "Estátua da Liberdade\n" +
                        "Visitar a famosa estátua ou vê-la, mesmo de longe, é um marco na vida de muitos turistas. Ela pode ser conhecida de perto, com desembarque em Liberty Island (ilha onde se encontra a estátua) ou em um passeio de barco onde possa ser feita a contemplação. Se você não faz questão de ver a estátua tão de perto ou não quer fazer o desembarque na ilha, uma boa opção é pegar o ferry para Staten Island, que é gratuito e oferece uma boa visão da Estátua da Liberdade.\n" +
                        "Times Square\n" +
                        "A Times Square em Nova York é o lugar mais visitado em Manhattan. Conhecida como The Crossroads of the World (O Cruzamento do Mundo), essa praça tem dezenas de telas LED brilhantes e está repleta de personagens peculiares. É um lugar imperdível para turistas e é onde o maior número de selfies são tiradas. Há algum tempo atrás a Times Square não era um lugar especial, mas, nos anos 90, o prefeito Giuliani e a Disney transformam a praça no atual espetáculo de luz e arquitetura.\n" +
                        "Central Park\n" +
                        "Central Park, em Nova York, é um dos parques urbanos mais visitados do mundo, somando cerca de 30 milhões de turistas ao ano. Com mais de 840 acres de extensão, o local se tornou um dos pontos turísticos preferidos da cidade, e pode ser visto em centenas de produções de Hollywood, o que contribuiu para torná-lo amplamente conhecido em todas as partes do planeta.\n" +
                        "Considerado um verdadeiro oásis natural no meio da cidade de Nova York, o Central Park tem dezenas de atrativos que vão desde a homenagem a John Lennon até os gramados onde moradores e turistas de Nova York tomam sol no verão.\n" +
                        "Brooklyn Bridge\n" +
                        "Principal meio de acesso entre o Brooklyn e a ilha de Manhattan, a Brooklyn Bridge é cruzada diariamente por mais de 120 mil veículos e 4 mil pedestres. Para os turistas, o local é uma ótima opção para conseguir ter vistas incríveis de Nova York e tirar fotos espetaculares. Além disso, o fato da ponte ter pouco menos de 2 km de extensão permite que os visitantes realizem o trajeto facilmente caminhando ou de bicicleta, o que contribuiu para que esse passeio se tornasse um dos mais populares da cidade.\n" +
                        "\n" +
                        "Ferry de Staten Island\n" +
                        "O passeio de ferry a Staten Island tem uma duração de 25 minutos e permite-lhe desfrutar de vistas deslumbrantes sobre a baixa de Manhattan, o New York Harbor, a Estátua da Liberdade e a Ellis Island. Este passeio é inteiramente gratuito e pode ser realizado a qualquer hora do dia. O terminal onde pode apanhar o ferry em Manhattan está localizado na South Street em Financial District, perto Wall Street. Aproveite que vai fazer esta viagem e desfrute do ambiente de Wall Street.\n" +
                        "\n" +
                        "The Cloisters\n" +
                        "Em Nova York pode encontrar diversos museus famosos que merecem ser visitados. O The Cloisters, apesar de não um dos museus mais famosos de Nova York, é uma experiência única onde pode apreciar obras de arte e relaxar com o ambiente tranquilo que aqui encontra. Este museu é uma extensão do Metropolitan Museum of Art e está dedicado a expor arte e arquitetura medieval da Europa. O The Cloisters está localizado no Fort Tryon Park, na zona norte de Manhattan. Não perca a oportunidade de conhecer este museu que é uma obra de arte só por si. O edifício e jardins foram construídos com partes de claustros medievais Franceses que foram desmantelados em 1934. A reunião dessas peças em Nova York foi realizada com o objetivo de criar uma atmosfera que vá de encontro às tradições medievais Europeias.\n" +
                        "High Line Park\n" +
                        "O High Line Park é uma atração de Manhattan que deverá conhecer. Este parque tem um comprimento de cerca de 2,5km e foi construído em cima da antiga linha de comboios elevada, ao longo do rio Hudson. Aberto ao público desde 2009, este parque oferece aos seus visitantes plantas naturais que foram aproveitadas da vegetação que cresceu durante a altura em que esta zona estava desocupada. Não perca a oportunidade de passear neste parque único em Nova York.\n" +
                        "New York Public Library\n" +
                        "A New York Public Library é uma das principais bibliotecas públicas do mundo. O edifício é uma referência da arquitetura em Nova York e um ponto de referencia histórico nacional. Numa visita à New York Public Library poderá encontrar à entrada os leões de nome Patience (Paciência) e Fortitude (Coragem), uma escadaria majestosa e glamorosas divisões com tetos enormes.\n" +
                        "\n" +
                        "Grand Central Station\n" +
                        "A Grand Central Station é um ponto de referência de Nova York que não vai querer perder. Para visitar este enorme estação de trem não necessita viajar para fora da cidade. Simplesmente apareça, observe a arquitetura do edifício por fora, e de seguida deslumbre-se com o seu interior.\n" +
                        "Golden Gate\n" +
                        "Famosa por ser cenário de diversos filmes, a Golden Gate é o principal cartão postal de San Francisco e uma das pontes mais visitadas do mundo. Inaugurada em 1937, a ponte de quase três quilômetros liga a cidade ao condado de Marin, ao norte da Baía. Um dos passeios mais legais é simplesmente fazer a travessia de bicicleta!\n" +
                        "Pier 39\n" +
                        "Um dos mais famosos pontos turísticos de San Francisco é o Pier 39! A cidade tem vários piers ao longo de sua costa, mas o número 39 que ganhou fama mundial. Na região estão concentradas diversas lojinhas de souvenir, restaurantes e bares variados, aquário, um pequeno parque de diversão e a sede de um projeto de preservação de leões marinhos. Podemos ainda assistir a shows ao ar livre, fazer passeios de barco e curtir a linda vista para a baia de San Francisco.\n" +
                        "Golden Gate Park\n" +
                        "Criado em 1870, o Golden Gate Park é o terceiro parque mais visitado nos Estados Unidos e está para San Francisco, assim como o Central Park está para Nova York. O espaço oferece uma grande variedade de atrações como: a California Academy of Science, Japanese Tea Garden, Botanical Garden, Shakespeare Garden, Conservatório de Flores, área para concertos musicais, quadras de esportes, campo de golfe, trilhas, lagos, entre outros. Vale lembrar que apesar do nome, o parque não está próximo a Golden Gate.\n" +
                        "\n" +
                        "Ilha de Alcatraz\n" +
                        "Incialmente uma base militar, a Ilha de Alcatraz ficou famosa por abrigar entre 1867 e 1963 um presídio. Considerada na época a prisão mais segura do mundo, ela abrigou diversos criminosos famosos, entre eles Al Capone! E até hoje sua exploração turística gira em torno de sua fama e das lendas. Além de conhecer um pouco mais da história, de lá se tem uma vista privilegiada da cidade.\n" +
                        "Lombard Street\n" +
                        "Cenário de inúmeros filmes, o quarteirão da Lombard Street entre as ruas Leavenworth St e Hyde é famoso por suas curvas emolduradas por jardins! Segundo a história, as oito curvas fechadas foram criadas em 1922 para reduzir a velocidade dos carros na descida. Hoje a Lombard Street é conhecida como a rua mais sinuosa do mundo.\n" +
                        "Aquarium of the Bay\n" +
                        "O Aquarium of the Bay é um espaço de preservação e conscientização sobre a importância da Bacia de San Francisco, onde é possível conhecer um pouco mais sobre a fauna marinha da região. Entre as principais atrações estão o balé das águas-vivas e os túneis transparentes de onde é possível observar tubarões, arraias e outros animais. A sensação é como se estivéssemos nadando entre eles.\n" +
                        "Sausalito\n" +
                        "Um passeio imperdível, principalmente para quem busca tranquilidade, é conhecer a pequena Sausalito. Localizada do outro lado da Baía de São Francisco, o vilarejo tem cerca de 7.000 moradores e abriga restaurantes, galerias de arte e lojinhas. Para chegar até lá a forma mais famosa e charmosa é a bicicleta, já que no trajeto conhecemos vários outros pontos turísticos.\n" +
                        "\n" +
                        "Parque Nacional Muir Woods\n" +
                        "O Parque Nacional Muir Woods, com suas sequoias gigantes, é outra atração famosa da região de San Francisco. Ele fica a cerca de 15 quilômetros da cidade e os visitantes podem escolher visitas guiadas e ou por conta própria. É um passeio bem interessante para conhecer a árvore ícone da Califórnia.\n" +
                        "\n" +
                        "Fisherman’s Wharf\n" +
                        "O Fisherman’s Wharf é um antigo porto de pescadores, que se tornou um dos lugares mais visitados de San Francisco. Oficialmente o Fisherman’s Wharf se estende do Píer 39 a Ghirardelli Square, mas seu trecho mais conhecido é na região do Píer 43.\n" +
                        "No espaço existem várias barraquinhas de gastronomia e a dica é experimentar o Dungeness Crab, um caranguejo gigante típico dessa região do Pacífico. Além disso, a região abriga outras atrações como o Aquarium of The Bay e o USS Pampanito, um submarino da Segunda Guerra Mundial que virou museu, além do The Cannery, um prédio histórico, datado de 1909, que atualmente abriga um shopping.\n" +
                        "The Lands End\n" +
                        "Localizado na costa oeste da cidade, o Lands End é um dos principais parques da cidade. Suas quatro trilhas principais levam sempre a uma bela vista da cidade da San Francisco e a dica é deixar o passeio no parque para o período da tarde, para observar de lá o pôr do sol e a Golden Gate.\n" +
                        " ");
                listHash.put(listDataHeader.get(0),introducao);
                listHash.put(listDataHeader.get(1),antesViagem);
                listHash.put(listDataHeader.get(2),Oquelevar);
                listHash.put(listDataHeader.get(3),curiosidades);
                listHash.put(listDataHeader.get(4),pontosTuristicos);
            }

            else if(toolbar.getTitle().toString().equalsIgnoreCase("França")){
                imgBandeira.setImageDrawable(ContextCompat.getDrawable(PaisAdapter.this,
                        R.drawable.ban_franca));
                imgTurismo.setImageDrawable(ContextCompat.getDrawable(PaisAdapter.this,
                        R.drawable.turis_franca));


                listDataHeader = new ArrayList<>();
                listHash = new HashMap<>();

                listDataHeader.add("Introdução");
                listDataHeader.add("Antes de Viajar");
                listDataHeader.add("O que levar");
                listDataHeader.add("Curiosidades");
                listDataHeader.add("Pontos Turisticos");

                List<String> introducao = new ArrayList<>();
                introducao.add("O turismo na França não se aplica somente a Paris. Sim, a capital francesa é tudo aquilo que dizem e ir a Paris é sempre uma experiência mágica. Não importa se é a primeira vez ou a décima, simplesmente estar em Paris é uma delícia. No entanto, existem muitas outras regiões da França para turismo. Aqui no blog, saiba tudo sobre a França, não apenas sobre o turismo, mas curiosidades e dicas para você conhecer mais afundo a cultura francesa.\n" +
                        "Viajar por várias regiões da França tem seu encanto. A Normandia, Alcácia, Cote D’Azur, Bordeaux e Borgonha costumam agradar muito aos turistas. Sem falar da Córsega, uma ilha paradisíaca pertencente à França.");

                List<String> antesViagem = new ArrayList<>();
                antesViagem.add("Os pedidos de visto solicitados no Brasil são concedidos pela Embaixada da França em Brasília e pelos Consulados-Gerais da França em São Paulo e no Rio de Janeiro.\n" +
                        "Para se informar, preparar e apresentar seu dossiê ou acompanhar o andamento do seu pedido, conecte-se a “France-visas\", o site oficial dos vistos para a França, a partir de um dos diferentes idiomas disponíveis (francês, inglês, espanhol).\n" +
                        "Os cidadãos brasileiros que desejarem se dirigir à França em viagem turística estarão isentos da exigência de visto.");

                List<String> Oquelevar = new ArrayList<>();
                Oquelevar.add("\n" +
                        "Bem como o seu kit de viagem habitual, estes são alguns extras que você pode querer levar junto com você:\n" +
                        "\n" +
                        "- Moeda Local: Como na maior parte da Europa, a moeda local na França é o Euro, dessa forma recomendamos sempre ir numa casa de câmbio e levar com você alguns Euros para ajuda-lo em sua viagem.\n" +
                        "-Tomada: O Padrão de tomadas europeu é diferente do nosso, dessa forma se faz interessante comprar um adaptador para a viagem.\n" +
                        "\n" +
                        "-Código de vestimenta: A França fica na Europa, apresentando um clima mais frio na maior parte do ano. Por mais que seja possível comprar lá, é recomendado sempre levar consigo algumas roupas de frio como garantia.");

                List<String> curiosidades = new ArrayList<>();
                curiosidades.add("\n" +
                        "-Os franceses são um povo bem quieto e difícil, mas eles também são muito educados. É sempre bom rezar para que nenhum problema aconteça quando você estiver viajando para a França, pois você será na maior parte das vezes ignorado. É muito recomendável que você tenha um bom nível de inglês, uma vez que as rixas passadas tornam o inglês uma língua não muito bem-vinda.\n" +
                        "\n" +
                        "- Viajar de trem pelo país é uma excelente alternativa, já que a França possui uma extensa malha ferroviária conectada com toda a Europa. Destaque para os serviços do trem de alta-velocidade TGV, que cobre os 776 quilômetros entre Paris a Marselha em apenas três horas.Dentro das cidades as opções são trens, bondes, metrô e ônibus, quase sempre cobertos por cartões locais de desconto. Bicicletas públicas estão disponíveis nas grandes localidades.\n" +
                        "\n" +
                        "- Poucos destinos comparam-se à França em termos gastronômicos. Aqui come-se muito bem e isso não significa gastar muito dinheiro. Apesar de ser a terra dos Guias Michelin e de chefs estrelados como Paul Bocuse, Alain Ducasse e da família Troisgrois — isso para não falar de uma das mais poderosas escolas gastronômicas do planeta — boa parte dos bistrôs, cafés e restaurantes do país oferece excelentes pratos a preços acessíveis.\n" +
                        "Um dos segredos dos restaurantes são os menus du jour, os cardápios do dia, que trazem uma entrada, um prato principal e uma sobremesa. De vez em quando há também uma taça da vinho da casa e café. É uma oferta e tanto.\n" +
                        "Seja como for, as opções transitam entre a nouvelle cuisine, repleta de receitas inovadoras, tanto no sabor como na apresentação, com muitos molhos, texturas, precisão técnica no preparo e surpresas. E porções pequenas. A cozinha de linha mais tradicional abusa de muita manteiga, pato, porco, queijos, coelho, cogumelos, legumes e verduras da terra e muita alegria. Cada região tem sua especialidade, abusando de ingredientes locais, com uma profusão de cores e delicadezas.\n" +
                        "Um capítulo à parte são os pães e docerias. As boulangeries não são meras padarias. Aqui você encontra uma ode à farinha. Baguete, croissant, éclair, brioche e pain au chocolat são apenas uma pequena amostra que você encontrará nelas. Nas patisseries, você verá tortas, doces, chocolates, bolos e macarons divinos.\n" +
                        "Vinhos e queijos são outros dois destaques da gastronomia francesa. Champagne, bordeaux e borgonha estão entre os melhores e mais disputados rótulos do mundo enológico. Mesmo safras ditas mais fracas e decepcionantes satisfazem os apreciadores iniciantes e intermediários. Já os fromages vem em formas, consistência e sabores totalmente distintos uns dos outros, como camembert, roquefort, gruyére e brie, os carros-chefe dessa importante indústria.\n" +
                        "Para ter certeza que sua viagem terá de tudo um pouco, os pratos mais emblemáticos da França incluem o bouillabaisse de Marselha (um ensopado de frutos do mar), o presunto cru de Bayonne, os escargots de Borgonha, o foie gras de Périgord e as linguiças andouillette. E, claro, o cozido de legumes ratatouille, que ninguém conhecia até poucos anos atrás.");

                List<String> pontosTuristicos = new ArrayList<>();
                pontosTuristicos.add("\n" +
                        "Paris\n" +
                        "\n" +
                        "Paris é um destino da França que sempre vale a pena. Mesmo que você já conheça a cidade-luz, sempre é bom voltar para Paris. Com certeza você descobrirá novas coisas para fazer, diferentes visuais e pontos de vista. Também é bem provável que tenha que ir até Paris para pegar o avião. Então já se prepare e saiba como ir do aeroporto ao centro de Paris. Descubra como fazer este trajeto a partir de todos os aeroportos da capital francesa. Estando em Paris, é bom entender como funciona o metrô e transporte público em Paris. Até quem já foi, vale dar uma estudada.\n" +
                        "\n" +
                        "Jardins de Monet, em Giverny.\n" +
                        "Nem só de Paris trata-se o turismo na França. O país, que é cheio de cidades turísticas e regiões interessantíssimas para conhecer, tem muito mais a oferecer.\n" +
                        "\n" +
                        "Igreja em Lyon.\n" +
                        "Lyon é outra boa dica. Uma das maiores e mais importantes cidades da França, considerada por muitos a mais bonita também.\n" +
                        "\n" +
                        "\n" +
                        "Lago de Annecy.\n" +
                        "Você também pode aproveitar e conhecer os Alpes Franceses. A região da França perto da Itália e Suíça, não é muito longe de Lyon. Por lá, veja onde ficar e o que fazer em Annecy. A cidadezinha de montanha, que tem um lago com mesmo nome, é encantadora e tem clima super romântico.\n" +
                        "\n" +
                        "\n" +
                        "Castelo no Vale do Loire.\n" +
                        "No Nordeste da França, na região de Lorena, Nancy é a principal cidade para conhecer. Perto de lá, na Alsácia, divisa com a Alemanha, esta Estrasburgo. A cidade medieval com fortes influências alemãs também é muito bonita e interessante.\n" +
                        "\n" +
                        "Riviera Francesa\n" +
                        "\n" +
                        "Curtir o verão europeu nas praias da Riviera Francesa, também não me parece um mau negócio. A região do litoral sul da França, banhado pelo Mediterrâneo, mais conhecida como Cote D’azur (Costa Azul), parte da fronteira com a Itália (dá até para estender a viagem até a Riviera Italiana).\n" +
                        "\n" +
                        "São muitos destinos legais para ir parando e conhecendo: Cannes, Nice, Saint-Tropez, Mônaco, Marselha. Saindo um pouquinho da costa, também tem a região da Provence, para conhecer seus lindos campos e comprar as famosas ervas.");
                listHash.put(listDataHeader.get(0),introducao);
                listHash.put(listDataHeader.get(1),antesViagem);
                listHash.put(listDataHeader.get(2),Oquelevar);
                listHash.put(listDataHeader.get(3),curiosidades);
                listHash.put(listDataHeader.get(4),pontosTuristicos);
            }

            else if(toolbar.getTitle().toString().equalsIgnoreCase("Espanha")){
                imgBandeira.setImageDrawable(ContextCompat.getDrawable(PaisAdapter.this,
                        R.drawable.ban_espanha));
                imgTurismo.setImageDrawable(ContextCompat.getDrawable(PaisAdapter.this,
                        R.drawable.turis_espanha));


                listDataHeader = new ArrayList<>();
                listHash = new HashMap<>();

                listDataHeader.add("Introdução");
                listDataHeader.add("Antes de Viajar");
                listDataHeader.add("O que levar");
                listDataHeader.add("Curiosidades");
                listDataHeader.add("Pontos Turisticos");

                List<String> introducao = new ArrayList<>();
                introducao.add("Tanta mistura proporcionou um cenário fantástico para o turismo, uma vez que dentro de um único país existem tantas diferenças. Desde o imenso respeito pelas tradições da Andaluzia, estado ao sul que mantém intactos muitos hábitos regionais, passando pelo separatista País Basco, até a região da Catalunha, onde está localizada Barcelona, a cidade mais visitada da Espanha, você encontrará tudo o que espera para uma viagem, e muito mais.");

                List<String> antesViagem = new ArrayList<>();
                antesViagem.add("Embora cidadãos brasileiros – em viagem de curta duração – sejam isentos de visto para entrar em terras espanholas, há uma série de outros documentos que podem ser exigidos pelos agentes da imigração no momento em que você chegar no país.\n" +
                        "Considera-se viagem de curta duração, aquela cuja estada no país para turismo, estudo ou negócios, não exceda 90 dias em um período de 180 dias. Caso a sua estada no país seja maior do que 90 dias você deve solicitar um visto.\n" +
                        "Segundo consta na página do Consulado Geral do Brasil em Madri, cerca de 40 brasileiros são proibidos de entrar na Espanha a cada mês. Portanto, se você está prestes a visitar o país, lembre-se de levar com você todos os documentos exigidos. Pode ser que os agentes da imigração simplesmente não exijam nada mas, pode ser que você seja o escolhido do dia e, neste caso, é melhor estar prevenido");

                List<String> Oquelevar = new ArrayList<>();
                Oquelevar.add("\n" +
                        "Bem como o seu kit de viagem habitual, estes são alguns extras que você pode querer levar junto com você:\n" +
                        "\n" +
                        "- Moeda Local: Como na maior parte da Europa, a moeda local na Espanha é o Euro, dessa forma recomendamos sempre ir numa casa de câmbio e levar com você alguns Euros para ajuda-lo em sua viagem.\n" +
                        "- Línguas: A Espanha é um país com muitos dialetos e línguas diferentes, então além do seu dicionário de Espanhol, recomendamos estudar alguma das outras línguas para não passar dificuldades dependendo do local que deseje visitar. \n" +
                        "\n" +
                        "-Tomada: O Padrão de tomadas europeu é diferente do nosso, dessa forma se faz interessante comprar um adaptador para a viagem.\n" +
                        "\n" +
                        "-Código de vestimenta: A Espanha fica na Europa, apresentando um clima mais frio na maior parte do ano. Por mias que seja possível comprar lá, é recomendado sempre levar consigo algumas roupas de frio como garantia.");

                List<String> curiosidades = new ArrayList<>();
                curiosidades.add("\n" +
                        "-Os espanhóis são um povo bem alegre e explosivo, mas eles também não são muito educados. É aconselhável sempre tomar cuidado, principalmente nas cidades grandes para não ser arrastado numa confusão e ter um bom entendimento da língua para emergências.\n" +
                        "\n" +
                        "- Viajar de trem pelo país é uma boa alternativa, já que a Espanha tem em torno de 15 mil quilômetros de ferrovias. A companhia Renfe serve com rapidez e pontualidade boa parte do país, inclusive os principais destinos turísticos. Ônibus também são boas alternativas, um pouco mais baratas que os trens, mas com jornadas mais demoradas. São diversas companhias operando linhas que tanto servem grandes centros como lugarejos mais distantes.\n" +
                        "Quem preferir viajar de carro vai trafegar sem dificuldade por autopistas de primeira linha.\n" +
                        "\n" +
                        "- A gastronomia espanhola é uma das melhores da Europa, para não falar do mundo. Os restaurantes da Espanha podem não ter os serviços mais atenciosos, mas a comida saborosa e farta compensa. Os dois símbolos da cozinha local que extrapolaram fronteiras são a paella e as tapas, mas cada uma possui dezenas de variantes. Em comum às paellas estão o arroz e a panela, mas os ingredientes que a enriquecem são múltiplos. Carne de coelho, frango, mariscos, camarões, caracóis, pimentões, mexilhões e azeitonas são algumas das opções, ora aromatizadas com açafrão, ora tingidas com tinta de sépia. Já as tapas, muito mais que um prato, são um conceito. Em sua origem, eram apenas um petisco servido sobre tacinhas de vinho xerez. Com o tempo tornaram-se tão complexas e assumiram uma identidade tão própria que possui infinitas receitas, de omeletinhos a pãezinhos cobertos com aliche a sanduichinhos de presunto cru a fritadas de lula. Um assombro.");

                List<String> pontosTuristicos = new ArrayList<>();
                pontosTuristicos.add("Granada\n" +
                        "\n" +
                        "Além de ser uma cidade com espírito jovem devido aos estudantes que frequentam uma das universidades locais, Granada, localizada aos pés de Sierra Nevada, também tem muito história pra contar. Foi aqui que no século XV os reis católicos expulsaram os mouros da Penílsula Ibérica, colocando fim aos quase 800 anos de domínio islâmico. \n" +
                        "Ibiza\n" +
                        "\n" +
                        "O sonho de solteiros e jovens casais que gostam de festas e baladas, Ibiza é um dos principais destinos de férias da Espanha, até mesmo da Europa. Além de festas na praia, clubes à beira-mar e casas noturnas, Ibiza também oferece lazer para quem procura praias paradisíacas e paisagens de tirar o fôlego. \n" +
                        "Madrid \n" +
                        "\n" +
                        "Ao lado de Barcelona, Madrid é a principal porta para os turistas que chegam a Espanha. \n" +
                        "\n" +
                        "Marbella \n" +
                        "\n" +
                        "Um destino que geralmente está fora do roteiro dos turistas brasileiros, mas é muito procurado por europeus. A cidade é um dos principais destinos de verão da Espanha, localizada na famosa Costa do Sol, região que recebe esse nome por ser abençoada com mais de 300 dias ensolarados durante o ano. \n" +
                        "\n" +
                        "Ronda \n" +
                        "\n" +
                        "Conhecer essa pacata cidade no sul da Espanha foi certamente uma das experiências mais surpreendentes que já tive. Pouco pesquisei sobre a cidade e não imaginava que seria um de meus destinos preferidos na Europa, com excelentes restaurantes, hotéis à beira de um lindo penhasco, paisagens e mais paisagens que alucinam qualquer fotógrafo. \n" +
                        "\n" +
                        "Salamanca \n" +
                        "\n" +
                        "Salamanca é certamente uma das principais cidades para estudar espanhol na Espanha, sendo bastante popular entre estrangeiros..\n" +
                        "\n" +
                        "San Sebastián\n" +
                        "\n" +
                        "San Sebastián ou Donostia (em basco) é uma cidade situada no País Basco, no norte da Espanha e uma das mais famosas do país, sendo eleita a Capital Européia da Cultura em 2016. Está rodeada pela Baía da Concha, chamada pelos bascos de “pequeno Rio de Janeiro”, por ter formato de meia-lua, lembrando a Baía de Guanabara.\n" +
                        "\n" +
                        "\n" +
                        "Tarifa\n" +
                        "\n" +
                        "A região é um paraíso para os surfistas à vela que viajam em busca de ventos perfeitos e constantes, mas não para por aí. A praia é uma das mais bonita da Espanha e o público jovem aproveita para curtir as festas e praticar esportes, principalmente mergulho, surf, windsurf e kitesurf.\n" +
                        "\n" +
                        "Toledo\n" +
                        "Toledo é uma pequena cidade medieval na Espanha, a 70km de Madrid\n" +
                        "\n" +
                        "Barcelona \n" +
                        "Junto com Madrid, Barcelona é o destino turístico mais procurado da Espanha. A cidade é super agitada, com turistas por todos os lados, motivados em grande parte a conhecer as obras de Gaudí\n" +
                        "\n" +
                        "Valência \n" +
                        "\n" +
                        "Mais uma cidade que é a cara da Espanha, recomendo que todos os viajantes planejem uma visita.\n" +
                        "\n" +
                        "Sevilha\n" +
                        "Sabe aquelas cidades que a gente não esquece! Sem falar em todas as belezas, Sevilha é pura alegria. Seu ritmo peculiar que vai além da siesta, aquela soneca pós o almoço, fácil de perceber ao ver as pessoas pelas ruas, bares e praças ao redor da cidade.");
                listHash.put(listDataHeader.get(0),introducao);
                listHash.put(listDataHeader.get(1),antesViagem);
                listHash.put(listDataHeader.get(2),Oquelevar);
                listHash.put(listDataHeader.get(3),curiosidades);
                listHash.put(listDataHeader.get(4),pontosTuristicos);
            }

            else if(toolbar.getTitle().toString().equalsIgnoreCase("India")){
                imgBandeira.setImageDrawable(ContextCompat.getDrawable(PaisAdapter.this,
                        R.drawable.ban_india));
                imgTurismo.setImageDrawable(ContextCompat.getDrawable(PaisAdapter.this,
                        R.drawable.turis_india));



                listDataHeader = new ArrayList<>();
                listHash = new HashMap<>();

                listDataHeader.add("Introdução");
                listDataHeader.add("Antes de Viajar");
                listDataHeader.add("O que levar");
                listDataHeader.add("Curiosidades");
                listDataHeader.add("Pontos Turisticos");

                List<String> introducao = new ArrayList<>();
                introducao.add("Com suas cidades movimentadas e comida picante mundialmente famosa, não é surpreendente que a " +
                        "Índia seja procurada por turistas. Os aventureiros estão sempre procurando descobrir a fauna e " +
                        "flora exótica que caracterizam a paisagem. No entanto, a enorme quantidade de coisas para se ver " +
                        "e fazer pode ser um pouco assustadora, portanto, segue abaixo um guia você planejar melhor sua viagem.");

                List<String> antesViagem = new ArrayList<>();
                antesViagem.add("Confira o seu visto: o governo indiano disponibilizou para vários países, incluindo o Brasil, " +
                        "o Visto de Turismo Eletrônico (e-TV). Ele tem duração de 30 dias a partir da data de chegada país e " +
                        "pode ser requisitado por no máximo duas vezes ao ano.\tVacine-se. Todos os turistas que visitam o " +
                        "país devem ser vacinados contra a hepatite A, tétano e febre tifoide. Há também um risco de malária.");

                List<String> Oquelevar = new ArrayList<>();
                Oquelevar.add("Bem como o seu kit de viagem habitual, estes são alguns extras que você pode querer levar junto com você:\n\n" +
                        "- Repelente de mosquitos: o país é cheio de insetos então leve repelentes para afastar qualquer destes animais durante a noite\n\n" +
                        "-Lenços umedecidos antibacterianos ou álcool em gel: sempre mantenha algum destes produtos higiênicos com você porque, em partes remotas do país, é quase impossível encontrar algum lugar para lavar as mãos.\n\n" +
                        "-Um sarongue: este item com múltiplas funções será muito útil. Bem como roupas, ele pode servir como um cobertor, toalha de emergência ou mesmo uma cortina improvisada para privacidade quando você está viajando.\n\n" +
                        "-Cadeado e corrente: vai viajar de trem? Estes itens são uma ótima maneira de garantir que sua bagagem fique em segurança.\n" +
                        "\n" +
                        "-Código de vestimenta: a maior parte do país ainda é bastante conservadora, então tente ser respeitoso com o vestuário local e evite roupas curtas.\n\n");

                List<String> curiosidades = new ArrayList<>();
                curiosidades.add("\n" +
                        "- Beba a água certa. A água da torneira é uma coisa a se evitar no país, mesmo quando você está escovando os dentes ou tomando um banho. A água engarrafada é sua amiga, mas certifique-se que está devidamente fechada. Também vale a pena evitar saladas enxaguadas em água da torneira e cubos de gelo não filtrados.\n" +
                        "\n" +
                        "-Eles podem parecer bonitos, mas você deve evitar animais que vivem nas ruas. O país tem a taxa a mais elevada de raiva no mundo e os cães e os macacos de rua podem te morder ou arranhar e transmitir doenças.\n\n" +
                        "- Comer com a mão esquerda é considerado sujo, então use a sua mão direita. Isso também se aplica ao encontrar pessoas\n\n – use sempre a mão direita. Além disso, mostrar as solas dos pés é considerado muito rude, então mantenha os cobertos, especialmente em torno de locais sagrados. \n" +
                        "\n" +
                        "- Seja esperto nas ruas. Seja educado, mas firme ao recusar a oferta de alguém que está oferecendo um táxi que você não pediu. Além disso, como em qualquer destino turístico, há falsos guias que se dirigem a grandes centros tentando enganar viajantes.\n" +
                        "\n" +
                        "- Tente evitar passear com mapas, câmeras e itens caros – e vale a pena aprender algumas frases-chave na língua local no caso de você precisar se comunicar em uma emergência.");

                List<String> pontosTuristicos = new ArrayList<>();
                pontosTuristicos.add("\n" +
                        "O festival das cores\n" +
                        "Imagine paintball levado ao extremo. O Holi, ou o festival das cores da Índia, é um evento Hindu gigante que acontece todo mês de março. Celebrando a chegada da primavera, é uma desculpa para encharcar todo mundo a sua volta com pós coloridos e dançar a noite toda.\n" +
                        "\n" +
                        "Templos de ouro\n" +
                        "No coração de Punjab, o Templo Dourado de Amritsar é um monumento profundamente sagrado para o Sikh, além de ser extremamento bonito.Os visitantes são bem-vindos, então passe pela linda passarela de mosaicos que passa sobre a água até o centro do complexo, e prepare-se para ficar espantado. Paredes laminadas de ouro, cúpulas de bronze e mármore decorativo com estampas compõem a visão de puro luxo. Vá à noite para ver o complexo iluminado por dentro e por fora, e para participar da veneração do livro sagrado da religião Sikh.\n" +
                        "\nBollyWood! \n" +
                        "Hollywood é o filho pobre da poderosa Bollywood. Com raízes em Mumbai, a indústria cinematográfica da Índia produz milhares de filmes e arrecada bilhões de rípias em bilheteria todos os anos.\n" +
                        "\nHimalaia\n" +
                        "Faz o estilo aventureiro? Então você não pode deixar de ver de perto o Himalaia. A paisagem é composta por picos pontudos cobertos de neve que parece diamante, acompanhados de pores do sol e amanheceres dignos de cinema e até alguns tigres-de-bengala vagando…\n" +
                        "\nFortes ocupados\n" +
                        "Viver em antigas fortalezas é uma realidade na Índia. Com uma história que data do século 12, Jaisalmer é um forte transformado em cidade que abriga nada menos que 3.000 moradores. É quase uma aventura desbravar suas ruas estreitas, templos superlotados e lojinhas curiosas que foram um verdadeiro labirinto. Entre próximo a Gopa Chawk e tente não se perder até chegar ao centro do forte!\n" +
                        "\nTemplos de pedras milenares\n" +
                        "Local sagrado desde o século 7, o majestoso templo Virupaksha em Hampi – a seis horas de carro de Bangalore – teve sua origem como um humilde santuário, mas fica até difícil imaginar esse arranha-céu milenar em seus tempos antigos. Às margens do rio Tungabhadra, essa maravilha de nove andares serve de santuário para a divindade Virupaksheshwara, e apesar de sentir o peso do tempo, ainda sedia inúmeras atividades – incluindo um festival anual de carruagens em fevereiro.\n" +
                        "\nParaíso da yoga\n" +
                        "Fãs de yoga e de meditação vão encontrar na Índia um verdadeiro paraíso. Originária do Hinduísmo, a yoga é a maneira tradicional de entrar em contato com seu eu interior – contorcendo seu eu exterior.\n" +
                        "\nO festival das luzes\n" +
                        "Diwali, também grafado como Dipawali, é o principal feriado indiano. Acontece todo mês de outubro ou novembro, e celebra o triunfo do bem sobre o mal, sendo conhecido como o “festival das luzes” – e há uma razão para isso.\n" +
                        "Lâmpadas a óleo enfeitam a frente das casas, luzes decorativas e muitos fogos de artifício transforam o país numa terra de luzes durante cinco dias. As festividades variam conforme a região do país, mas tudo brilha e muito esteja onde você estiver na Índia, especialmente em Chennai.");

                listHash.put(listDataHeader.get(0),introducao);
                listHash.put(listDataHeader.get(1),antesViagem);
                listHash.put(listDataHeader.get(2),Oquelevar);
                listHash.put(listDataHeader.get(3),curiosidades);
                listHash.put(listDataHeader.get(4),pontosTuristicos);


            }
        }


        listAdapter = new ListaExpansivaAdapter(this, listDataHeader, listHash);
        listView.setAdapter(listAdapter);

    }
}
