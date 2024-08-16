#include<stdio.h>
#include<stdlib.h>
#define null NULL

void inserting_first();
void inserting_end();
void deleting_first();
void deleting_end();
void display();

struct node 
{
    int data;
    struct node* pre;
    struct node* next;
};

struct node* head=null;
struct node* tail=null;

void inserting_first()
{
   struct node* newnode = (struct node*)malloc(sizeof(struct node));
        printf("enter data: \n");
        scanf("%d",&newnode->data);
    if(head==0)
    {
        
        head=newnode;
        newnode->pre=head;
        newnode->next=head;
        head->pre=tail;
    }else{
        
        head->pre=newnode;
        newnode->next=head;
        head=newnode;
        newnode->pre=tail;
        tail->next=newnode;
    }
}


void inserting_end()
{
    struct node* newnode=(struct node*)malloc(sizeof(struct node));
    printf("enter data: \n");
    scanf("%d",&newnode->data);
    struct node*temp;
    if(head==null)
    {
        head->next=newnode;
        newnode->pre=head;
        head=newnode;
        newnode->next=head;
        head->pre=tail;
    }else{
        temp=head;
        head=head->next;
        temp->next=null;
        head->pre=tail;
        tail->next=head;
        free(temp);
    }
}


void deleting_first()
{
    struct node*temp;
      struct node* newnode=(struct node*)malloc(sizeof(struct node));
    if(head==null)
    {
    printf("list is empty:\n");
    }
    else
    {
        temp=head;
        head=head->next;
        temp->next=null;
        head->pre=tail;
        tail->next=head;
        free(temp);
    
    }
}


void deleting_end()
{
    struct node* temp;
      struct node* newnode=(struct node*)malloc(sizeof(struct node));
    if(head==null)
    {
        printf("list is empty: \n");
    }else{
        temp=head;
        while(temp->next!=0)
        {
            temp=tail;
            tail=tail->pre;
            temp->pre=null;
            tail->next=head;
            head->pre=tail;
        }
    }
}


void display()
{
    struct node*temp;
    if(head==null)
    {
        printf("list is empty:\n");
    }
    else
    {
        temp=head;
        while(temp!=head)
        {
            printf("%d\n",temp->data);
            temp=temp->next;
        }
    }
}


int main()
{
    int ch;
    while(1)
    {
        printf("enter the choice:\n 1.inserting_first()\n 2.inserting_end()\n 3.deleting_first()\n 4.deleting_end()\n 5.display()\n");
        scanf("%d",&ch);
        switch(ch)
        {
            case 1: inserting_first();
            break;
            case 2: inserting_end();
            break;
            case 3: deleting_first();
            break;
            case 4: deleting_end();
            break; 
            case 5: display();
            break;
            default: printf("invalid choice");
        }
            return 0;
     }                                              
}