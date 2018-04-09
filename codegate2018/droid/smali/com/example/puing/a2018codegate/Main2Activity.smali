.class public Lcom/example/puing/a2018codegate/Main2Activity;
.super Landroid/support/v7/app/c;


# instance fields
.field l:Landroid/widget/EditText;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Landroid/support/v7/app/c;-><init>()V

    return-void
.end method

.method public static a(Ljava/lang/String;)Ljava/lang/String;
    .locals 10

    const/4 v1, 0x0

    const-string v3, ""

    const-string v0, ""

    const/16 v2, 0x1c

    new-array v6, v2, [C

    fill-array-data v6, :array_0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v7

    move v4, v1

    move-object v5, v0

    :goto_0
    if-ge v4, v7, :cond_3

    invoke-virtual {p0, v4}, Ljava/lang/String;->charAt(I)C

    move-result v0

    invoke-static {v6}, Ljava/lang/String;->valueOf([C)Ljava/lang/String;

    move-result-object v2

    add-int v8, v7, v4

    invoke-virtual {v2, v8}, Ljava/lang/String;->charAt(I)C

    move-result v2

    xor-int/2addr v0, v2

    move v2, v0

    move v0, v1

    :goto_1
    array-length v8, v6

    add-int/lit8 v8, v8, -0x1

    if-ge v0, v8, :cond_1

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v8

    invoke-static {v6}, Ljava/lang/String;->valueOf([C)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v9, v0}, Ljava/lang/String;->charAt(I)C

    move-result v9

    invoke-static {v9}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_0

    new-instance v2, Ljava/util/Random;

    invoke-direct {v2}, Ljava/util/Random;-><init>()V

    invoke-virtual {v2}, Ljava/util/Random;->nextInt()I

    move-result v2

    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_1
    move v0, v1

    :goto_2
    if-ge v0, v2, :cond_2

    add-int/2addr v0, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    :cond_2
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    add-int/lit8 v0, v4, 0x1

    move v4, v0

    move-object v5, v2

    goto :goto_0

    :cond_3
    move-object v0, v3

    :goto_3
    if-ge v1, v7, :cond_4

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v5, v1}, Ljava/lang/String;->charAt(I)C

    move-result v2

    xor-int/2addr v2, v1

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    add-int/lit8 v1, v1, 0x1

    goto :goto_3

    :cond_4
    return-object v0

    :array_0
    .array-data 2
        0x63s
        0x6fs
        0x64s
        0x65s
        0x67s
        0x61s
        0x74s
        0x65s
        0x32s
        0x30s
        0x31s
        0x38s
        0x68s
        0x75s
        0x72s
        0x72s
        0x61s
        0x79s
        0x21s
        0x48s
        0x41s
        0x48s
        0x41s
        0x48s
        0x41s
        0x4cs
        0x4fs
        0x4cs
    .end array-data
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3

    const v2, 0x7f080076

    invoke-super {p0, p1}, Landroid/support/v7/app/c;->onCreate(Landroid/os/Bundle;)V

    const v0, 0x7f0a001c

    invoke-virtual {p0, v0}, Lcom/example/puing/a2018codegate/Main2Activity;->setContentView(I)V

    const v0, 0x7f0800aa

    invoke-virtual {p0, v0}, Lcom/example/puing/a2018codegate/Main2Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/Toolbar;

    invoke-virtual {p0, v0}, Lcom/example/puing/a2018codegate/Main2Activity;->a(Landroid/support/v7/widget/Toolbar;)V

    const v0, 0x7f080047

    invoke-virtual {p0, v0}, Lcom/example/puing/a2018codegate/Main2Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/FloatingActionButton;

    new-instance v1, Lcom/example/puing/a2018codegate/Main2Activity$1;

    invoke-direct {v1, p0}, Lcom/example/puing/a2018codegate/Main2Activity$1;-><init>(Lcom/example/puing/a2018codegate/Main2Activity;)V

    invoke-virtual {v0, v1}, Landroid/support/design/widget/FloatingActionButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    invoke-static {}, Lcom/example/puing/a2018codegate/MainActivity;->k()Z

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    invoke-virtual {p0, v2}, Lcom/example/puing/a2018codegate/Main2Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    const-string v1, "hi there"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    :goto_0
    const v0, 0x7f08003e

    invoke-virtual {p0, v0}, Lcom/example/puing/a2018codegate/Main2Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/example/puing/a2018codegate/Main2Activity;->l:Landroid/widget/EditText;

    iget-object v0, p0, Lcom/example/puing/a2018codegate/Main2Activity;->l:Landroid/widget/EditText;

    const-string v1, "enter your password"

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    invoke-virtual {p0}, Lcom/example/puing/a2018codegate/Main2Activity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "edittext"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const v0, 0x7f080025

    invoke-virtual {p0, v0}, Lcom/example/puing/a2018codegate/Main2Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    new-instance v2, Lcom/example/puing/a2018codegate/Main2Activity$2;

    invoke-direct {v2, p0, v1}, Lcom/example/puing/a2018codegate/Main2Activity$2;-><init>(Lcom/example/puing/a2018codegate/Main2Activity;Ljava/lang/String;)V

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    return-void

    :cond_0
    invoke-virtual {p0, v2}, Lcom/example/puing/a2018codegate/Main2Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/example/puing/a2018codegate/Main2Activity;->finishAffinity()V

    goto :goto_0
.end method
