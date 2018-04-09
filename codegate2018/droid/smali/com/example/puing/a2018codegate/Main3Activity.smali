.class public Lcom/example/puing/a2018codegate/Main3Activity;
.super Landroid/support/v7/app/c;


# instance fields
.field l:Landroid/widget/EditText;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Landroid/support/v7/app/c;-><init>()V

    return-void
.end method


# virtual methods
.method public k()Ljava/lang/String;
    .locals 5

    const/16 v0, 0x24

    new-array v1, v0, [C

    fill-array-data v1, :array_0

    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    new-instance v3, Ljava/util/Random;

    invoke-direct {v3}, Ljava/util/Random;-><init>()V

    const/4 v0, 0x0

    :goto_0
    const/16 v4, 0x14

    if-ge v0, v4, :cond_0

    array-length v4, v1

    invoke-virtual {v3, v4}, Ljava/util/Random;->nextInt(I)I

    move-result v4

    aget-char v4, v1, v4

    invoke-virtual {v2, v4}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_0
    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    :array_0
    .array-data 2
        0x61s
        0x62s
        0x63s
        0x64s
        0x65s
        0x66s
        0x67s
        0x68s
        0x69s
        0x6as
        0x6bs
        0x6cs
        0x6ds
        0x6es
        0x6fs
        0x70s
        0x71s
        0x72s
        0x73s
        0x74s
        0x75s
        0x76s
        0x77s
        0x78s
        0x79s
        0x7as
        0x30s
        0x31s
        0x32s
        0x33s
        0x34s
        0x35s
        0x36s
        0x37s
        0x38s
        0x39s
    .end array-data
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3

    const v2, 0x7f080076

    invoke-super {p0, p1}, Landroid/support/v7/app/c;->onCreate(Landroid/os/Bundle;)V

    const v0, 0x7f0a001d

    invoke-virtual {p0, v0}, Lcom/example/puing/a2018codegate/Main3Activity;->setContentView(I)V

    const v0, 0x7f0800aa

    invoke-virtual {p0, v0}, Lcom/example/puing/a2018codegate/Main3Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/Toolbar;

    invoke-virtual {p0, v0}, Lcom/example/puing/a2018codegate/Main3Activity;->a(Landroid/support/v7/widget/Toolbar;)V

    const v0, 0x7f080047

    invoke-virtual {p0, v0}, Lcom/example/puing/a2018codegate/Main3Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/FloatingActionButton;

    new-instance v1, Lcom/example/puing/a2018codegate/Main3Activity$1;

    invoke-direct {v1, p0}, Lcom/example/puing/a2018codegate/Main3Activity$1;-><init>(Lcom/example/puing/a2018codegate/Main3Activity;)V

    invoke-virtual {v0, v1}, Landroid/support/design/widget/FloatingActionButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    invoke-static {}, Lcom/example/puing/a2018codegate/MainActivity;->k()Z

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    invoke-virtual {p0, v2}, Lcom/example/puing/a2018codegate/Main3Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    const-string v1, "hi there"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    :goto_0
    const v0, 0x7f08003e

    invoke-virtual {p0, v0}, Lcom/example/puing/a2018codegate/Main3Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/example/puing/a2018codegate/Main3Activity;->l:Landroid/widget/EditText;

    iget-object v0, p0, Lcom/example/puing/a2018codegate/Main3Activity;->l:Landroid/widget/EditText;

    const-string v1, "type serial key"

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    const v0, 0x7f080025

    invoke-virtual {p0, v0}, Lcom/example/puing/a2018codegate/Main3Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    new-instance v1, Lcom/example/puing/a2018codegate/Main3Activity$2;

    invoke-direct {v1, p0}, Lcom/example/puing/a2018codegate/Main3Activity$2;-><init>(Lcom/example/puing/a2018codegate/Main3Activity;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    return-void

    :cond_0
    invoke-virtual {p0, v2}, Lcom/example/puing/a2018codegate/Main3Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/example/puing/a2018codegate/Main3Activity;->finishAffinity()V

    goto :goto_0
.end method
